package pers.howard.personalspace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.ShareDao;
import pers.howard.personalspace.dao.UserDao;
import pers.howard.personalspace.model.*;
import pers.howard.personalspace.service.ManageService;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ShareDao shareDao;

    @Autowired
    UserDao userDao;

    @Override
    public void savePublishItem(PublishItem publishItem) {
        ShareItem shareItem = publishItem.exportShareItem();
        String shareId = saveShareItem(shareItem);
        PhotoItem photoItem = new PhotoItem();
        photoItem.setShareId(shareId);
        photoItem.setPhotoPath(publishItem.getPhotoPath());
        savePhotoPath(photoItem);
    }

    @Override
    public String saveShareItem(ShareItem shareItem) {
        shareDao.insertShareItem(shareItem);
        return shareItem.getShareId();
    }

    @Override
    public String savePhotoPath(PhotoItem photoItem) {
        shareDao.insertPhotoItem(photoItem);
        return photoItem.getPhotoId();
    }

    @Override
    public String nameAtUserId(String userId) {
        return userDao.retrieveNameAtUserId(userId);
    }

    @Override
    public PersonItem[] friendAtUserId(String userId, int offset, int size) {
        return userDao.friendAtUserId(userId, offset, size);
    }

    @Override
    public int friendCountAtUserId(String userId) {
        return userDao.friendCountAtUserId(userId);
    }

    @Override
    public void deleteFriendAtUserIdAndFriendId(String userId, String friendId) {
        userDao.deleteFriendAtUserIdAndFriendId(userId, friendId);
    }

    @Override
    public TagItem[] tagAtUserId(String userId) {
        return userDao.tagAtUserId(userId);
    }

    @Override
    public PersonItem[] friendInTagId(String tagId) {
        return userDao.friendInTagId(tagId);
    }

    @Override
    public PersonItem[] friendNotInTagId(String tagId, String userId) {
        return userDao.friendNotInTagId(tagId, userId);
    }

    @Override
    public void deleteTagRelationshipAtTagId(String tagId) {
        userDao.deleteTagRelationshipAtTagId(tagId);
    }

    @Override
    public void insertTagRelationship(String tagId, String userId, String[] friendIdArray) {
        if (friendIdArray.length == 0)
            return ;
        userDao.insertTagRelationship(tagId, userId, friendIdArray);
    }

    @Override
    public PersonItem userAtUserId(String userId) {
        return userDao.userAtUserId(userId);
    }

    @Override
    public void updateAtUserId(PersonItem personItem) {
        userDao.updateAtUserId(personItem);
    }

    @Override
    public void createTag(String tagName, String userId) {
        userDao.createTag(tagName, userId);
    }
}
