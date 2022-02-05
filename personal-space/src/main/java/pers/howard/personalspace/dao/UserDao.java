package pers.howard.personalspace.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.howard.personalspace.model.PersonItem;

@Mapper
public interface UserDao {
    void updateBasic(@Param("item") PersonItem personItem);
    PersonItem retrieveBasic(@Param("userID") String userID);
}
