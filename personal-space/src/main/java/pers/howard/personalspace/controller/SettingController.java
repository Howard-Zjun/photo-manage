package pers.howard.personalspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.howard.personalspace.model.PersonDataItem;
import pers.howard.personalspace.model.PreferenceItem;

@Controller
@RequestMapping("/personal/setting")
public class SettingController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex() {

    }

    /**
     * 更新基本信息
     * @param personDataItem 个人资料模组
     */
    @RequestMapping(value = "/basic/update", method = RequestMethod.POST)
    public void updateBasic(@RequestBody PersonDataItem personDataItem) {

    }

    /**
     * 查询基本信息
     * @param userID 用户ID
     * @return
     */
    @RequestMapping(value = "/basic/retrieve", method = RequestMethod.POST)
    @ResponseBody
    public PersonDataItem retrieveBasic(@RequestBody String userID) {

    }

    /**
     * 更新头像
     * @param userID 用户ID
     * @param file 头像
     */
    @RequestMapping(value = "/icon/update", method = RequestMethod.POST)
    public void updateIcon(@RequestBody String userID, @RequestParam("file") MultipartFile file) {

    }

    /**
     * 更新个人偏好
     * @param preferenceItem 偏好模组
     */
    @RequestMapping(value = "/prefer/update", method = RequestMethod.POST)
    public void updatePrefer(@RequestBody PreferenceItem preferenceItem) {

    }

    /**
     * 查询个人偏好
     * @param userID
     * @return
     */
    @RequestMapping(value = "/prefer/retrieve", method = RequestMethod.POST)
    @ResponseBody
    public PreferenceItem retrievePrefer(@RequestBody String userID) {

    }
}
