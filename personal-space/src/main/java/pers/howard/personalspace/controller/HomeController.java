package pers.howard.personalspace.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.model.SharePreviewItem;
import pers.howard.personalspace.service.HomeService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomeController {

    @Resource
    HomeService homeService;

    @GetMapping("/index")
    public String toIndex(@RequestParam(value = "index", required = false, defaultValue = "0") int index, Model model) {
        PageHelper.startPage(index, 3);
        List<SharePreviewItem> list = homeService.previewItems();
        PageInfo<SharePreviewItem> pageInfo = new PageInfo<>(list);
        model.addAttribute("list", pageInfo.getList());
        return "index";
    }

    @GetMapping("/detail")
    public String toDetail(@RequestParam("id") String id, Model model) {
        ShareDetailItem article = homeService.detailItems(id);
        List<RemarkItem> remarks = homeService.remarkItems(id);
        String name = homeService.personalItemName(id);
        model.addAttribute("article", article);
        model.addAttribute("remarks", remarks);
        model.addAttribute("name", name);
        return "index-detail";
    }
}
