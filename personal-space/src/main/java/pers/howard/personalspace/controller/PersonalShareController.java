package pers.howard.personalspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareItem;

import java.util.List;

@Controller
@RequestMapping("/personal/share")
public class PersonalShareController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex() {

    }

    /**
     * 获取动态组
     * @param userID 用户ID
     * @param page 页数
     * @return
     */
    @RequestMapping(value = "/retrieve", method = RequestMethod.POST)
    @ResponseBody
    public List<ShareItem> retrieve(@RequestBody String userID, @RequestParam("page") int page) {

    }

    /**
     * 更新动态状态
     * @param shareID 动态ID
     */
    @RequestMapping(value = "/status/update", method = RequestMethod.POST)
    public void updateStatus(@RequestBody String shareID) {

    }

    /**
     * 删除动态
     * @param shareID 动态ID
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String shareID) {

    }

    /**
     * 评论
     * @param remarkItem 评论模型
     */
    @RequestMapping(value = "/remark", method = RequestMethod.POST)
    public void remark(@RequestBody RemarkItem remarkItem) {

    }

    /**
     * 点赞
     * @param shareID 动态ID
     */
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public void like(@RequestBody String shareID) {

    }
}
