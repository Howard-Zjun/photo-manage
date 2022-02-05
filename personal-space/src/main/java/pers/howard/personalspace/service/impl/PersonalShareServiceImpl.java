package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.ShareDao;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.service.PersonalShareService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonalShareServiceImpl implements PersonalShareService {

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
    public void remarkWith(RemarkItem remarkItem) {
        shareDao.remarkWith(remarkItem);
    }

    @Override
    public void likeAt(String shareID) {
        shareDao.likeAt(shareID);
    }
}
