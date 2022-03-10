package pers.howard.personalspace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.ShareDao;
import pers.howard.personalspace.dao.UserDao;
import pers.howard.personalspace.model.PhotoItem;
import pers.howard.personalspace.model.PublishItem;
import pers.howard.personalspace.model.ShareItem;
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
    public String getNameAt(String userId) {
        return userDao.retrieveNameAtUserId(userId);
    }
}
