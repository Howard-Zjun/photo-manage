package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.UserDao;
import pers.howard.personalspace.model.RegisterItem;
import pers.howard.personalspace.service.LoginService;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserDao userDao;

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
}
