package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.LogRemarkItem;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.service.DetailService;

import java.util.List;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    DetailService detailService;

    @GetMapping("/index")
    public String toIndex(@RequestParam("shareId") String shareId, Model model) {
        ShareDetailItem article = detailService.detailItem(shareId);
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
    public void likeAt(@RequestBody LikeItem likeItem) {
        detailService.increaseLike(likeItem);
    }
}
