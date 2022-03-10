package pers.howard.personalspace.service;

import pers.howard.personalspace.model.PhotoItem;
import pers.howard.personalspace.model.PublishItem;
import pers.howard.personalspace.model.ShareItem;

public interface ManageService {

    void savePublishItem(PublishItem publishItem);

    String saveShareItem(ShareItem shareItem);

    String savePhotoPath(PhotoItem photoItem);

    String getNameAt(String userId);
}
