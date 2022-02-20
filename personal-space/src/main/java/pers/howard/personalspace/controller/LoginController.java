package pers.howard.personalspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.howard.personalspace.model.LoginItem;
import pers.howard.personalspace.model.LoginResultItem;
import pers.howard.personalspace.model.RegisterItem;
import pers.howard.personalspace.model.RegisterResultItem;
import pers.howard.personalspace.service.LoginService;
import pers.howard.personalspace.service.RedisService;

import javax.servlet.http.Cookie;
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

    @PostMapping("/check")
    @ResponseBody
    public LoginResultItem check(@RequestBody LoginItem loginItem, HttpServletResponse response) {
        int userId = loginService.checkPasswordAtEmail(loginItem.getEmail(), loginItem.getPassword());
        LoginResultItem loginResultItem = new LoginResultItem();
        if (userId > 0) {
            loginResultItem.setPath("/index");
            String token = UUID.randomUUID().toString().replace("-", "");
            Cookie userCookie = new Cookie("userId", String.valueOf(userId));
            Cookie tokenCookie = new Cookie("token", token);
            userCookie.setPath("/");
            tokenCookie.setPath("/");
            response.addCookie(userCookie);
            response.addCookie(tokenCookie);
            redisService.setTokenItem(String.valueOf(userId), token);
        } else {
            loginResultItem.setError("密码错误");
        }
        return loginResultItem;
    }

    @PostMapping("/register")
    @ResponseBody
    public RegisterResultItem register(@RequestBody RegisterItem registerItem, HttpServletResponse response) {
        int userId = loginService.register(registerItem);
        RegisterResultItem registerResultItem = new RegisterResultItem();
        if (userId > 0) {
            registerResultItem.setPath("/index");
            String token = UUID.randomUUID().toString().replace("-", "");
            Cookie userCookie = new Cookie("userId", String.valueOf(userId));
            Cookie tokenCookie = new Cookie("token", token);
            response.addCookie(userCookie);
            response.addCookie(tokenCookie);
            redisService.setTokenItem(String.valueOf(userId), token);
        } else {
            registerResultItem.setError("邮箱以注册");
        }
        return registerResultItem;
    }
}
