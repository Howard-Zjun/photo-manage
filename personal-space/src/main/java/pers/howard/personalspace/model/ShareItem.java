package pers.howard.personalspace.model;

import java.util.Date;
import java.util.List;

/**
 * 动态模型
 */
public class ShareItem {
    private String name;
    private Date date;
    private String headIcon;
    private String detail;
    private List<String> images;
    private int visitNum;
    private List<RemarkItem> remarks;
    private int goodNum;
    private boolean isShow;

    public ShareItem(String name, Date date, String headIcon, String detail, List<String> images, int visitNum, List<RemarkItem> remarks, int goodNum) {
        this.name = name;
        this.date = date;
        this.headIcon = headIcon;
        this.detail = detail;
        this.images = images;
        this.visitNum = visitNum;
        this.remarks = remarks;
        this.goodNum = goodNum;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(int visitNum) {
        this.visitNum = visitNum;
    }

    public List<RemarkItem> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<RemarkItem> remarks) {
        this.remarks = remarks;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }
}
