package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.ShareDao;
import pers.howard.personalspace.model.PhotoPreviewItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.model.TagItem;
import pers.howard.personalspace.service.PersonalService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Resource
    ShareDao shareDao;

    @Override
    public List<ShareDetailItem> retrieveAt(String userID, int page) {
        return shareDao.retrieveDetailAt(userID, page);
    }

    @Override
    public boolean retrieveStatusAt(String shareID) {
        return shareDao.retrieveStatusAt(shareID);
    }

    @Override
    public void updateStatusAt(String shareID, boolean status) {
        shareDao.updateStatusAt(shareID, status);
    }

    @Override
    public void deleteAt(String shareID) {
        shareDao.deleteAt(shareID);
    }

    @Override
    public List<PhotoPreviewItem> previewItems(String userId) {
        return shareDao.retrievePersonalPreviewAt(userId);
    }

    @Override
    public List<String> previewTags(List<PhotoPreviewItem> list) {
        HashSet<String> set = new HashSet<>();
        for (PhotoPreviewItem item : list) {
            for (String str : item.splitTags())
                set.add(str);
        }
        return new ArrayList<>(set);
    }

    @Override
    public String IdGroupAtShareId(String shareId) {
        return shareDao.retrieveTagGroupAtShare(shareId);
    }

    @Override
    public TagItem[] idInIdsAtUserId(String[] ids) {
        if (ids == null) {
            return new TagItem[0];
        }
        return shareDao.idInIds(ids);
    }

    @Override
    public TagItem[] idNotInIdsAtUserId(String[] ids, String userId) {
        if (ids == null) {
            return shareDao.retrieveTagAtUser(userId);
        }
        return shareDao.idNotInIds(ids, userId);
    }
}
