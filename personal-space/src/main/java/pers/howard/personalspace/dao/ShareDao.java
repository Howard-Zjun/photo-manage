package pers.howard.personalspace.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.model.SharePreviewItem;

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
    boolean retrieveStatusAt(@Param("shareID") String shareID);
    void deleteAt(@Param("shareID") String shareID);
    void remarkWith(RemarkItem remarkItem);
    void likeAt(String shareID);
}
