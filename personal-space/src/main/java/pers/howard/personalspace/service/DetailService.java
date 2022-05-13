package pers.howard.personalspace.service;

import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.LogRemarkItem;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;

import java.util.List;

public interface DetailService {
    /**
     * 获取文章内容
     * @param shareId
     * @return
     */
    ShareDetailItem detailItem(String shareId);

    /**
     * 获取文章评论
     * @param shareId
     * @return
     */
    List<RemarkItem> remarkItems(String shareId);

    /**
     * 获去文章作者名
     * @param shareId
     * @return
     */
    String authorName(String shareId);

    /**
     * 添加评论
     * @param remarkItem
     */
    void addRemarkItem(LogRemarkItem remarkItem);

    void likeShareAt(LikeItem likeItem);

    int isLike(LikeItem likeItem);

    void delikeShareAt(LikeItem likeItem);

    int likeCountAt(String shareId);

    int remarkCountAt(String shareId);
}
