package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.model.PublishItem;
import pers.howard.personalspace.model.ResultItem;
import pers.howard.personalspace.service.ManageService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @Autowired
    ToolKit toolKit;

    @Value("${local.cookie.userId-name}")
    private String userIdName;

    @GetMapping("/index")
    public String toIndex(Model model, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        String name = manageService.getNameAt(userId);
        model.addAttribute("name", name);
        return "manage";
    }

    @PostMapping("/publish")
    @ResponseBody
    public ResultItem publish(@RequestBody PublishItem publishItem) {
        manageService.savePublishItem(publishItem);
        ResultItem resultItem = new ResultItem("red", "发布成功");
        return resultItem;
    }
}
