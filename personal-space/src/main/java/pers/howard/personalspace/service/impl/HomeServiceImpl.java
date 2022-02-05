package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import pers.howard.personalspace.dao.ShareDao;
import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
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
    public ShareDetailItem detailItems(String shareId) {
        return shareDao.retrieveDetailAt(shareId);
    }

    @Override
    public List<RemarkItem> remarkItems(String shareId) {
        return shareDao.retrieveRemarkAt(shareId);
    }

    @Override
    public String personalItemName(String shareId) {
        return shareDao.retrievePersonItemName(shareId);
    }
}
