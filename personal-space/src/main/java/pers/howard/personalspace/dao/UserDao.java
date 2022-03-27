package pers.howard.personalspace.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.howard.personalspace.model.PersonItem;
import pers.howard.personalspace.model.RegisterItem;
import pers.howard.personalspace.model.TagItem;

@Mapper
public interface UserDao {

    /**
     * 用户信息
     */
    PersonItem userAtUserId(@Param("userId") String userId);

    /**
     * 更新信息
     */
    void updateAtUserId(PersonItem personItem);

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

    /**
     * 根据id查询用户名
     */
    String retrieveNameAtUserId(@Param("userId") String userId);

    /**
     * 查询用户的好友
     */
    PersonItem[] friendAtUserId(@Param("userId") String userId, @Param("offset") int offset, @Param("size") int size);

    /**
     * 朋友数量
     */
    int friendCountAtUserId(@Param("userId") String userId);

    /**
     * 删除好友关系
     */
    void deleteFriendAtUserIdAndFriendId(@Param("userId") String userId, @Param("friendId") String friendId);

    /**
     * 所使用的标签
     */
    TagItem[] tagAtUserId(@Param("userId") String userId);

    /**
     * 标签涉及的好友
     */
    PersonItem[] friendInTagId(@Param("tagId") String tagId);

    /**
     * 标签不涉及的好友
     */
    PersonItem[] friendNotInTagId(@Param("tagId") String tagId, @Param("userId") String userId);

    /**
     * 删除标签关系
     */
    void deleteTagRelationshipAtTagId(@Param("tagId") String tagId);

    /**
     * 插入标签关系
     */
    void insertTagRelationship(@Param("tagId") String tagId, @Param("userId") String userId, @Param("friendIdArray") String[] friendIdArray);
}
