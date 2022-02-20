package pers.howard.personalspace.service;

import pers.howard.personalspace.model.RegisterItem;

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
}
