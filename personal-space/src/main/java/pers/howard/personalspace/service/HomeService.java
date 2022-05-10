package pers.howard.personalspace.service;

import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.SharePreviewItem;

import java.util.List;

public interface HomeService {
    List<SharePreviewItem> previewItems();

    /**
     * 点赞
     * @param likeItem
     */
    void likeAt(LikeItem likeItem);

    public boolean isAuthorityVisit(String shareId, String userId, String friendId, String permissionsTagGroup);
}
