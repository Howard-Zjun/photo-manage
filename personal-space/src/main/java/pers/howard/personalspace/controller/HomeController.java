package pers.howard.personalspace.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.SharePreviewItem;
import pers.howard.personalspace.service.HomeService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/index")
    public String toIndex(@RequestParam(value = "index", required = false, defaultValue = "0") int index, Model model) {
        PageHelper.startPage(index, 3);
        List<SharePreviewItem> list = homeService.previewItems();
        PageInfo<SharePreviewItem> pageInfo = new PageInfo<>(list);
        model.addAttribute("list", pageInfo.getList());
        return "index";
    }


    @PostMapping("/like")
    @ResponseBody
    public void likeAt(@RequestBody LikeItem likeItem) {
        homeService.likeAt(likeItem);
    }
}
