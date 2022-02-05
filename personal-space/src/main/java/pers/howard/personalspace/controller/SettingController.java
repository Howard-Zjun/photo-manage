package pers.howard.personalspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.howard.personalspace.model.PersonItem;
import pers.howard.personalspace.model.PreferenceItem;
import pers.howard.personalspace.service.SettingService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/setting")
public class SettingController {

    @Resource
    SettingService settingService;

    @GetMapping("/index")
    public String toIndex(Model model) {
        return "index";
    }

    /**
     * 更新基本信息
     * @param personItem 个人资料模组
     */
    @PostMapping("/basic/update")
    public void updateBasic(@RequestBody PersonItem personItem) {
        settingService.updateBasicWith(personItem);
    }

    /**
     * 查询基本信息
     * @param userID 用户ID
     * @return
     */
    @PostMapping("/basic/retrieve")
    @ResponseBody
    public PersonItem retrieveBasic(@RequestBody String userID) {
        return settingService.retrieveBasicAt(userID);
    }

    /**
     * 更新头像
     * @param userID 用户ID
     * @param file 头像
     */
    @PostMapping("/icon/update")
    public void updateIcon(@RequestBody String userID, @RequestParam("file") MultipartFile file) {
        settingService.updateHeadIconAt(userID, file);
    }

    /**
     * 更新个人偏好
     * @param preferenceItem 偏好模组
     */
    @PostMapping(value = "/prefer/update")
    public void updatePrefer(@RequestBody PreferenceItem preferenceItem) {
        settingService.updatePreferenceWith(preferenceItem);
    }

    /**
     * 查询个人偏好
     * @param userID
     * @return
     */
    @PostMapping(value = "/prefer/retrieve")
    @ResponseBody
    public PreferenceItem retrievePrefer(@RequestBody String userID) {
        return settingService.retrievePreferenceAt(userID);
    }
}
