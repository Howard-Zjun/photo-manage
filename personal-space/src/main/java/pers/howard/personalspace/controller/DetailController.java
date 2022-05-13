package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.LogRemarkItem;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.service.DetailService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    DetailService detailService;

    @Autowired
    ToolKit toolKit;

    @Value("${local.cookie.userId-name}")
    private String userIdName;

    @GetMapping("/index")
    public String toIndex(@RequestParam("shareId") String shareId, Model model, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        ShareDetailItem article = detailService.detailItem(shareId);
        int likeCount = detailService.likeCountAt(shareId);
        int remarkCount = detailService.remarkCountAt(shareId);
        article.setLikeNum(likeCount);
        article.setRemarkNum(remarkCount);
        LikeItem likeItem = new LikeItem(shareId, userId);
        article.setIsLike(detailService.isLike(likeItem) > 0 ? true : false);
        List<RemarkItem> remarks = detailService.remarkItems(shareId);
        String name = detailService.authorName(shareId);
        model.addAttribute("article", article);
        model.addAttribute("remarks", remarks);
        model.addAttribute("name", name);
        return "detail";
    }

    @PostMapping("/remark")
    @ResponseBody
    public void remark(@RequestBody LogRemarkItem logRemarkItem) {
        detailService.addRemarkItem(logRemarkItem);
    }

    @PostMapping("/like")
    @ResponseBody
    public HashMap updateLikeStatus(@RequestBody LikeItem likeItem) {
        HashMap ret = new HashMap<>();
        if (detailService.isLike(likeItem) > 0) {
            detailService.delikeShareAt(likeItem);
            ret.put("isActive", false);
        } else {
            detailService.likeShareAt(likeItem);
            ret.put("isActive", true);
        }
        ret.put("likeCount", detailService.likeCountAt(likeItem.getShareId()));
        return ret;
    }
}
