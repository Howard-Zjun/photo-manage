package pers.howard.personalspace.service;

import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.SharePreviewItem;

import java.util.List;

public interface HomeService {
    List<SharePreviewItem> previewItems();

    void likeShareAt(LikeItem likeItem);

    int isLike(LikeItem likeItem);

    void delikeShareAt(LikeItem likeItem);

    int likeCountAt(String shareId);

    int remarkCountAt(String shareId);

    boolean isAuthorityVisit(String shareId, String userId, String friendId, String permissionsTagGroup);
}
