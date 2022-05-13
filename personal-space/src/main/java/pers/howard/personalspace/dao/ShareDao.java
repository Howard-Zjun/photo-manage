package pers.howard.personalspace.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.howard.personalspace.model.*;

import java.util.List;

@Mapper
public interface ShareDao {
    void updateStatusAt(@Param("shareID") String shareID, @Param("status") boolean status);
    List<ShareDetailItem> retrieveDetailAt(@Param("userID") String userID, @Param("page") int page);

    /**
     * 检索多个文章预览
     */
    List<SharePreviewItem> retrievePreviewAt();

    /**
     * 检索文章内容
     */
    ShareDetailItem retrieveDetailAt(@Param("shareId") String shareId);

    /**
     * 检索文章评论
     */
    List<RemarkItem> retrieveRemarkAt(@Param("shareId") String shareId);

    /**
     * 检索文章作者名
     */
    String retrievePersonItemName(@Param("shareId") String shareId);

    /**
     * 新增评论
     */
    void insertRemarkItem(@Param("item") LogRemarkItem logRemarkItem);

    Integer likeCountAt(@Param("shareId") String shareId);

    Integer remarkCountAt(@Param("shareId") String shareId);

    void likeShareAt(@Param("shareId") String shareId, @Param("userId") String userId);

    Integer isLike(@Param("shareId") String shareId, @Param("userId") String userId);

    void delikeShareAt(@Param("shareId") String shareId, @Param("userId") String userId);

    /**
     * 检索个人文章预览
     */
    List<PhotoPreviewItem> retrievePersonalPreviewAt(@Param("userId") String userId);

    /**
     * 插入新分享动态
     */
    void insertShareItem(@Param("item") ShareItem shareItem);

    /**
     * 插入照片连接
     */
    void insertPhotoItem(@Param("item") PhotoItem photoItem);

    /**
     * 根据标签id查询名字
     */
    TagItem[] idInIds(@Param("ids") String[] ids);

    TagItem[] idNotInIds(@Param("ids") String[] ids, @Param("userId") String userId);

    /**
     * 查询文章的所用的标签组
     */
    String retrieveTagGroupAtShare(@Param("shareId") String shareId);

    /**
     * 查询用户创建的所有标签
     */
    TagItem[] retrieveTagAtUser(@Param("userId") String userId);

    boolean retrieveStatusAt(@Param("shareID") String shareID);
    void deleteAt(@Param("shareID") String shareID);

    void updateTagAtShare(@Param("shareId") String shareId, @Param("tagIdGroup") String tagIdGroup);
}
