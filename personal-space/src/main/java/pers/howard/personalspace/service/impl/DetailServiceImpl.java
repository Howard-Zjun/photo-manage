package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.ShareDao;
import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.LogRemarkItem;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.service.DetailService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Resource
    ShareDao shareDao;

    @Override
    public ShareDetailItem detailItem(String shareId) {
        return shareDao.retrieveDetailAt(shareId);
    }

    @Override
    public List<RemarkItem> remarkItems(String shareId) {
        return shareDao.retrieveRemarkAt(shareId);
    }

    @Override
    public String authorName(String shareId) {
        return shareDao.retrievePersonItemName(shareId);
    }

    @Override
    public void addRemarkItem(LogRemarkItem logRemarkItem) {
        shareDao.insertRemarkItem(logRemarkItem);
    }

    @Override
    public void increaseLike(LikeItem likeItem) {
        shareDao.increaseLikeAt(Integer.valueOf(likeItem.getShareId()));
    }
}
