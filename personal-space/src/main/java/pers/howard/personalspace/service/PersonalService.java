package pers.howard.personalspace.service;

import pers.howard.personalspace.model.PhotoPreviewItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.model.TagItem;

import java.util.List;

public interface PersonalService {
    List<ShareDetailItem> retrieveAt(String userID, int page);
    void updateStatusAt(String shareID, boolean status);
    boolean retrieveStatusAt(String shareID);
    void deleteAt(String shareID);
    List<PhotoPreviewItem> previewItems(String userId);
    List<String> previewTags(List<PhotoPreviewItem> list);

    String IdGroupAtShareId(String shareId);

    TagItem[] idInIdsAtUserId(String[] ids);

    TagItem[] idNotInIdsAtUserId(String[] ids, String userId);
}
