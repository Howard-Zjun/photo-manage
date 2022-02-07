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

    /**
     * 文章点赞增长
     */
    void increaseLikeAt(String shareId);

    /**
     * 检索个人文章预览
     */
    List<PhotoPreviewItem> retrievePersonalPreviewAt(@Param("userId") String userId);

    boolean retrieveStatusAt(@Param("shareID") String shareID);
    void deleteAt(@Param("shareID") String shareID);
    void remarkWith(RemarkItem remarkItem);

}
