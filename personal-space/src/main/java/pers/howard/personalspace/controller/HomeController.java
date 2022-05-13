package pers.howard.personalspace.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.SharePreviewItem;
import pers.howard.personalspace.service.HomeService;
import pers.howard.personalspace.service.RedisService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    ToolKit toolKit;

    @Value("${local.cookie.userId-name}")
    private String userIdName;

    @Autowired
    RedisService redisService;

    @GetMapping("/index")
    public String toIndex(@RequestParam(value = "index", required = false, defaultValue = "1") int index, Model model, HttpServletRequest request) {
        List<SharePreviewItem> list = homeService.previewItems();
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        if (cookie == null || cookie.getValue() == null || redisService.getTokenItem(cookie.getValue()) == null) {
            list = noLoginFilter(list);
        } else {
            list = loginFilter(list, cookie.getValue());
        }
        PageHelper.startPage(index, 3);
        PageInfo<SharePreviewItem> pageInfo = new PageInfo<>(list);
        List<SharePreviewItem> resList = pageInfo.getList();
        for (int i = 0; i < resList.size(); i++) {
            int likeCount = homeService.likeCountAt(resList.get(i).getShareId());
            int remarkCount = homeService.remarkCountAt(resList.get(i).getShareId());
            resList.get(i).setLikeNum(likeCount);
            resList.get(i).setRemarkNum(remarkCount);
            if (cookie != null && cookie.getValue() != null && redisService.getTokenItem(cookie.getValue()) != null) {
                LikeItem likeItem = new LikeItem(resList.get(i).getShareId(), cookie.getValue());
                resList.get(i).setIsLike(homeService.isLike(likeItem) > 0 ? true : false);
            }
        }
        model.addAttribute("minIndex", 0);
        model.addAttribute("index", index);
        model.addAttribute("isHasNextPage", pageInfo.isHasNextPage());
        model.addAttribute("list", resList);
        return "index";
    }


    @PostMapping("/like")
    @ResponseBody
    public HashMap likeAt(@RequestBody LikeItem likeItem) {
        HashMap ret = new HashMap<>();
        if (homeService.isLike(likeItem) > 0) {
            homeService.delikeShareAt(likeItem);
            ret.put("isActive", false);
        } else {
            homeService.likeShareAt(likeItem);
            ret.put("isActive", true);
        }
        ret.put("likeCount", homeService.likeCountAt(likeItem.getShareId()));
        return ret;
    }

    public List<SharePreviewItem> noLoginFilter(List<SharePreviewItem> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getTagIdGroup() != null)
                list.remove(i);
        }
        return list;
    }

    public List<SharePreviewItem> loginFilter(List<SharePreviewItem> list, String friendId) {
        for (int i = list.size() - 1; i >= 0; i--) {
            boolean result = homeService.isAuthorityVisit(list.get(i).getShareId(), list.get(i).getUserId(), friendId, list.get(i).getTagIdGroup());
            if (!result)
                list.remove(i);
        }
        return list;
    }

}
