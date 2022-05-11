package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.model.*;
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
     * @param shareItem getShareId 动态ID
     */
    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody ShareItem shareItem) {
        personalService.deleteAt(shareItem.getShareId());
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
    public void updateTagAtShare(@RequestBody UpdateShareTagItem updateShareTagItem) {
        String[] temp = updateShareTagItem.getTagIds();
        String tagIdGroup = null;
        if (!(temp == null || temp.length == 0)) {
            tagIdGroup = temp[0];
            for (int i = 1; i < temp.length; i++) {
                tagIdGroup += ";" + temp[i];
            }
        }
        personalService.updateTagAtShare(updateShareTagItem.getShareId(), tagIdGroup);
    }
}
