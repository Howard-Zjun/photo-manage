package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.ShareDao;
import pers.howard.personalspace.model.LikeItem;
import pers.howard.personalspace.model.SharePreviewItem;
import pers.howard.personalspace.service.HomeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    ShareDao shareDao;

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
}
