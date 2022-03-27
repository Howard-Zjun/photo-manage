package pers.howard.personalspace.model;

import lombok.Data;

/**
 * 个人资料模型
 */
@Data
public class PersonItem {
    private String userId;// 唯一码
    private String name;
    private String password;
    private boolean sex;
    private String address;
    private String birth;
    private String phone;
    private String email;
    private String introduce;
    private String realName;
}
