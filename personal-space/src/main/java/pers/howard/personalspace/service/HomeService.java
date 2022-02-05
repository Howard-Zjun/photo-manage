package pers.howard.personalspace.service;

import pers.howard.personalspace.model.RemarkItem;
import pers.howard.personalspace.model.ShareDetailItem;
import pers.howard.personalspace.model.SharePreviewItem;

import java.util.List;

public interface HomeService {
    List<SharePreviewItem> previewItems();
    ShareDetailItem detailItems(String shareId);
    List<RemarkItem> remarkItems(String shareId);
    String personalItemName(String shareId);
}
