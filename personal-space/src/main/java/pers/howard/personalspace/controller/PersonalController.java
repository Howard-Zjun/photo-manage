package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.model.PhotoPreviewItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.service.PersonalService;

import java.util.List;

@Controller
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @GetMapping("/index")
    public String toIndex(@RequestParam("userId") String userId, Model model) {
        List<PhotoPreviewItem> previewItems = personalService.previewItems(userId);
        List<String> tags = personalService.previewTags(previewItems);
        tags.add(0, "All");
        model.addAttribute("previewItems", previewItems);
        model.addAttribute("tags", tags);
        return "personal";
    }

    /**
     * 获取动态组
     * @param userID 用户ID
     * @param page 页数
     * @return
     */
    @PostMapping("/retrieve")
    @ResponseBody
    public List<ShareDetailItem> retrieve(@RequestBody String userID, @RequestParam("page") int page) {
        return personalService.retrieveAt(userID, page);
    }

    /**
     * 更新动态状态
     * @param shareID 动态ID
     */
    @PostMapping("/status/update")
    public void updateStatus(@RequestBody String shareID, @RequestParam("status") boolean status) {
        personalService.updateStatusAt(shareID, status);
    }

    /**
     * 删除动态
     * @param shareID 动态ID
     */
    @DeleteMapping("/delete")
    public void delete(@RequestBody String shareID) {
        personalService.deleteAt(shareID);
    }
}
