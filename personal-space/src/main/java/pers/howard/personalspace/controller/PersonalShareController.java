package pers.howard.personalspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.service.PersonalShareService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/personal")
public class PersonalShareController {

    @Resource
    PersonalShareService personalShareService;

    @GetMapping("/index")
    public String toIndex() {
        return "personal";
    }

    @GetMapping("/detail")
    public String toDetail() {
        return "personal-detail";
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
        return personalShareService.retrieveAt(userID, page);
    }

    /**
     * 更新动态状态
     * @param shareID 动态ID
     */
    @PostMapping("/status/update")
    public void updateStatus(@RequestBody String shareID, @RequestParam("status") boolean status) {
        personalShareService.updateStatusAt(shareID, status);
    }

    /**
     * 删除动态
     * @param shareID 动态ID
     */
    @DeleteMapping("/delete")
    public void delete(@RequestBody String shareID) {
        personalShareService.deleteAt(shareID);
    }

    /**
     * 评论
     * @param remarkItem 评论模型
     */
    @PostMapping("/remark")
    public void remark(@RequestBody RemarkItem remarkItem) {
        personalShareService.remarkWith(remarkItem);
    }

    /**
     * 点赞
     * @param shareID 动态ID
     */
    @PostMapping("/like")
    public void like(@RequestBody String shareID) {
        personalShareService.likeAt(shareID);
    }
}
