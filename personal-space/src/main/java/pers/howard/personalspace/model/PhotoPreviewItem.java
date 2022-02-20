package pers.howard.personalspace.model;

public class PhotoPreviewItem {
    protected String shareId;
    protected String photoPath;
    protected String tags;
    protected boolean show;

    public String[] splitTags() {
        return tags.split(";");
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getTags() {
        String ret = "";
        for (String temp : tags.split(";"))
            ret += ",\"" + temp + "\"";
        return "\"All\"" + ret;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
