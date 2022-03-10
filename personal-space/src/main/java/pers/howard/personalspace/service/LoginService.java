package pers.howard.personalspace.service;

import pers.howard.personalspace.model.RegisterItem;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    /**
     * 验证
     * @param email
     * @param password
     * @return userId
     */
    int checkPasswordAtEmail(String email, String password);

    /**
     * 注册
     * @param registerItem
     * @return userId
     */
    int register(RegisterItem registerItem);

    /**
     * 根据名字获取Cookie
     * @param request
     * @param name
     * @return
     */
    Cookie getSingleCookieAtName(HttpServletRequest request, String name);
}
