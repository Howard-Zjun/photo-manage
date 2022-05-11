package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.ShareDao;
import pers.howard.personalspace.dao.UserDao;
import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.PersonItem;
import pers.howard.personalspace.model.SharePreviewItem;
import pers.howard.personalspace.service.HomeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    ShareDao shareDao;
    @Resource
    UserDao userDao;

    @Override
    public List<SharePreviewItem> previewItems() {
        List<SharePreviewItem> ret;
        ret = shareDao.retrievePreviewAt();
        return ret;
    }

    @Override
    public void likeAt(LikeItem likeItem) {
        Integer value = Integer.valueOf(likeItem.getShareId());
        shareDao.increaseLikeAt(value);
    }

    @Override
    public boolean isAuthorityVisit(String shareId, String userId, String friendId, String permissionsTagGroup) {
        if (userId.equals(friendId) || permissionsTagGroup == null)
            return true;
        if (userDao.isFriend(userId, friendId) == 0)
            return false;
        String[] permissionsTag = permissionsTagGroup.split(";");
        for (int i = 0; i < permissionsTag.length; i++) {
            PersonItem[] personItems = userDao.friendInTagId(permissionsTag[i]);
            for (PersonItem item : personItems) {
                if (item.getUserId().equals(friendId))
                    return false;
            }
        }
        return true;
    }
}
