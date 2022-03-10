package pers.howard.personalspace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.dao.UserDao;
import pers.howard.personalspace.model.RegisterItem;
import pers.howard.personalspace.service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserDao userDao;

    @Autowired
    ToolKit toolKit;

    @Override
    public int checkPasswordAtEmail(String email, String password) {
        String temp = userDao.retrievePasswordAtEmail(email);
        if (temp.equals(password))
            return userDao.retrieveUserIdAtEmail(email);
        return -1;
    }

    @Override
    public int register(RegisterItem registerItem) {
        if (userDao.retrieveRowAtEmail(registerItem.getEmail()) > 0)
            return -1;
        userDao.insertUser(registerItem);
        return userDao.retrieveUserIdAtEmail(registerItem.getEmail());
    }

    @Override
    public Cookie getSingleCookieAtName(HttpServletRequest request, String name) {
        return toolKit.getSingleCookieAtName(request, name);
    }
}
