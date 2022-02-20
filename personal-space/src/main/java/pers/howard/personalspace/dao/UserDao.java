package pers.howard.personalspace.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.howard.personalspace.model.PersonItem;
import pers.howard.personalspace.model.RegisterItem;

@Mapper
public interface UserDao {
    void updateBasic(@Param("item") PersonItem personItem);
    PersonItem retrieveBasic(@Param("userID") String userID);

    /**
     * 检索密码
     */
    String retrievePasswordAtEmail(@Param("email") String email);

    /**
     * 检索是否存在email
     */
    int retrieveRowAtEmail(@Param("email") String email);

    /**
     * 新用户注册
     */
    void insertUser(@Param("item") RegisterItem registerItem);

    /**
     * 检索用户ID
     */
    Integer retrieveUserIdAtEmail(@Param("email") String email);
}
