package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.model.LoginItem;
import pers.howard.personalspace.model.LoginResultItem;
import pers.howard.personalspace.model.RegisterItem;
import pers.howard.personalspace.model.RegisterResultItem;
import pers.howard.personalspace.service.LoginService;
import pers.howard.personalspace.service.RedisService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    RedisService redisService;

    @GetMapping("/index")
    public String toIndex() {
        return "login";
    }

    @Value("${local.cookie.token-name}")
    private String tokenName;

    @Value("${local.cookie.userId-name}")
    private String userIdName;

    @Autowired
    ToolKit toolKit;

    @PostMapping("/check")
    @ResponseBody
    public LoginResultItem check(@RequestBody LoginItem loginItem, HttpServletResponse response, HttpServletRequest request) {
        int userId = loginService.checkPasswordAtEmail(loginItem.getEmail(), loginItem.getPassword());
        LoginResultItem loginResultItem = new LoginResultItem();
        if (userId > 0) {
            loginResultItem.setPath("/index");
            String token = UUID.randomUUID().toString().replace("-", "");
            Cookie userCookie = loginService.getSingleCookieAtName(request, userIdName);
            Cookie tokenCookie = loginService.getSingleCookieAtName(request, tokenName);
            if (userCookie == null) {
                userCookie = new Cookie(userIdName, String.valueOf(userId));
                userCookie.setPath("/");
                userCookie.setMaxAge(toolKit.getTokenKeepTimeInSecond());
                response.addCookie(userCookie);
            }
            if (tokenCookie == null) {
                tokenCookie = new Cookie(tokenName, token);
                tokenCookie.setPath("/");
                tokenCookie.setMaxAge(toolKit.getTokenKeepTimeInSecond());
                response.addCookie(tokenCookie);
            }
            redisService.setTokenItem(String.valueOf(userId), token);
        } else {
            loginResultItem.setError("密码错误");
        }
        return loginResultItem;
    }

    @PostMapping("/register")
    @ResponseBody
    public RegisterResultItem register(@RequestBody RegisterItem registerItem, HttpServletResponse response, HttpServletRequest request) {
        int userId = loginService.register(registerItem);
        RegisterResultItem registerResultItem = new RegisterResultItem();
        if (userId > 0) {
            registerResultItem.setPath("/index");
            String token = UUID.randomUUID().toString().replace("-", "");
            Cookie userCookie = loginService.getSingleCookieAtName(request, userIdName);
            Cookie tokenCookie = loginService.getSingleCookieAtName(request, tokenName);
            if (userCookie == null) {
                userCookie = new Cookie(userIdName, String.valueOf(userId));
                userCookie.setPath("/");
                response.addCookie(userCookie);
            }
            if (tokenCookie == null) {
                tokenCookie = new Cookie(tokenName, token);
                tokenCookie.setPath("/");
                response.addCookie(tokenCookie);
            }
            redisService.setTokenItem(String.valueOf(userId), token);
        } else {
            registerResultItem.setError("邮箱以注册");
        }
        return registerResultItem;
    }
}
