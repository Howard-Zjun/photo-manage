package pers.howard.personalspace.service;

import pers.howard.personalspace.model.*;

public interface ManageService {

    void savePublishItem(PublishItem publishItem);

    String saveShareItem(ShareItem shareItem);

    String savePhotoPath(PhotoItem photoItem);

    String nameAtUserId(String userId);

    PersonItem[] friendAtUserId(String userId, int offset, int size);

    int friendCountAtUserId(String userId);

    void deleteFriendAtUserIdAndFriendId(String userId, String friendId);

    TagItem[] tagAtUserId(String userId);

    PersonItem[] friendInTagId(String tagId);

    PersonItem[] friendNotInTagId(String tagId, String userId);

    void deleteTagRelationshipAtTagId(String tagId);

    void insertTagRelationship(String tagId, String userId, String[] friendIdArray);

    PersonItem userAtUserId(String userId);

    void updateAtUserId(PersonItem personItem);
}
