package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.model.*;
import pers.howard.personalspace.service.ManageService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String name = manageService.nameAtUserId(userId);
        model.addAttribute("name", name);
        return "manage-push";
    }

    @PostMapping("/publish")
    @ResponseBody
    public ResultItem publish(@RequestBody PublishItem publishItem) {
        manageService.savePublishItem(publishItem);
        ResultItem resultItem = new ResultItem("red", "发布成功");
        return resultItem;
    }

    @GetMapping("/friend/index")
    public String toFriendIndex(@RequestParam(value = "page", required = false, defaultValue = "0") int page, Model model, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        int size = 7;
        int offset = page * size;
        PersonItem[] friends = manageService.friendAtUserId(userId, offset, size);
        int friendCount = manageService.friendCountAtUserId(userId);
        String name = manageService.nameAtUserId(userId);
        model.addAttribute("name", name);
        model.addAttribute("friends", friends);
        model.addAttribute("friendCount", friendCount);
        return "manage-friend";
    }

    @PostMapping("/friend/delete")
    @ResponseBody
    public ResultItem deleteFriend(@RequestBody PersonItem personItem, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        String friendId = personItem.getUserId();
        manageService.deleteFriendAtUserIdAndFriendId(userId, friendId);
        ResultItem resultItem = new ResultItem("green", "成功删除好友");
        return resultItem;
    }

    @GetMapping("/tag/index")
    public String toTagIndex(Model model, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        TagItem[] tags = manageService.tagAtUserId(userId);
        List<HashMap<String, Object>> list = new ArrayList<>();
        for (TagItem tag : tags) {
            HashMap<String, Object> tempMap = new HashMap<>();
            tempMap.put("id", tag.getTagId());
            tempMap.put("label", tag.getName());
            PersonItem[] activeFriends = manageService.friendInTagId(tag.getTagId());
            HashMap[] childrenMap = new HashMap[activeFriends.length];
            for (int i = 0; i < activeFriends.length; i++) {
                childrenMap[i] = new HashMap<>();
                childrenMap[i].put("id", activeFriends[i].getUserId());
                childrenMap[i].put("label", activeFriends[i].getName());
            }
            tempMap.put("children", childrenMap);
            list.add(tempMap);
        }
        String name = manageService.nameAtUserId(userId);
        model.addAttribute("tags", list);
        model.addAttribute("name", name);
        return "manage-tag";
    }

    @GetMapping("/tag")
    @ResponseBody
    public Map singleTagRelationshipAtTagId(@RequestParam("tagId") String tagId, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        PersonItem[] activeFriends = manageService.friendInTagId(tagId);
        PersonItem[] notActiveFriends = manageService.friendNotInTagId(tagId, userId);
        map.put("activeFriends", activeFriends);
        map.put("notActiveFriends", notActiveFriends);
        return map;
    }

    @PostMapping("/tag/update")
    @ResponseBody
    public void tagRelationshipUpdate(@RequestBody TagRelationshipItem tagRelationshipItem, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        manageService.deleteTagRelationshipAtTagId(tagRelationshipItem.getTagId());
        manageService.insertTagRelationship(tagRelationshipItem.getTagId(), userId, tagRelationshipItem.getUserIdArray());
    }

    @GetMapping("/info/index")
    public String toInfoIndex(Model model, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        PersonItem personItem = manageService.userAtUserId(userId);
        personItem.setPassword(null);
        model.addAttribute("user", personItem);
        return "manage-info";
    }

    @GetMapping("/info/edit/index")
    public String toInfoEditIndex(Model model, HttpServletRequest request) {
        Cookie cookie = toolKit.getSingleCookieAtName(request, userIdName);
        String userId = cookie.getValue();
        PersonItem personItem = manageService.userAtUserId(userId);
        personItem.setPassword(null);
        model.addAttribute("user", personItem);
        return "manage-info-edit";
    }

    @PostMapping("/info/edit/update")
    @ResponseBody
    public void userUpdate(@RequestBody PersonItem personItem) {
        manageService.updateAtUserId(personItem);
    }

    @GetMapping("/quit")
    @ResponseBody
    public void quit(HttpServletRequest request) {

    }
}
