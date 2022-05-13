package pers.howard.personalspace.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SharePreviewItem {
    protected String shareId;
    protected String userId;
    protected String title;
    protected Date sendDate;
    protected String detail;
    protected String tags;
    protected String photoPath;
    protected String tagIdGroup;
    protected int remarkNum;
    protected int likeNum;

    protected String[] monthName = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    public String defaultDateFormat() {
        if (sendDate == null)
            return "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sendDate);
        final int month = calendar.get(Calendar.MONTH);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" dd, yyyy");
        return monthName[month] + simpleDateFormat.format(sendDate);
    }
    public String[] defaultTagsFormat() {
        return tags.split(";");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public int getRemarkNum() {
        return remarkNum;
    }

    public void setRemarkNum(int remarkNum) {
        this.remarkNum = remarkNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getTagIdGroup() { return tagIdGroup; }

    public void setTagIdGroup(String tagIdGroup) {
        this.tagIdGroup = tagIdGroup;
    }
}
