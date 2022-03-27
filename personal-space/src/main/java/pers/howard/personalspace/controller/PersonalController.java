package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.model.PhotoPreviewItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.model.TagItem;
import pers.howard.personalspace.model.UpdateShareTagItem;
import pers.howard.personalspace.service.PersonalService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @Autowired
    ToolKit toolKit;

    @Value("${local.cookie.userId-name}")
    private String userIdName;

    @GetMapping("/index")
    public String toIndex(Model model, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
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

    @GetMapping("/tag")
    @ResponseBody
    public Map retrieveShareTag(@RequestParam("shareId") String shareId, @RequestParam("userId") String userId) {
        String idGroup = personalService.IdGroupAtShareId(shareId);
        HashMap<String, Object> map = new HashMap<>();
        String[] tagIds = null;
        if (idGroup != null) {
            tagIds = idGroup.split(";");
        }
        TagItem[] useTag = personalService.idInIdsAtUserId(tagIds);
        TagItem[] noUseTag = personalService.idNotInIdsAtUserId(tagIds, userId);
        map.put("useTag", useTag);
        map.put("noUseTag", noUseTag);
        return map;
    }

    @PostMapping("/confirm")
    @ResponseBody
    public boolean updateTagAtShare(@RequestBody UpdateShareTagItem updateShareTagItem) {
        return true;
    }
}
