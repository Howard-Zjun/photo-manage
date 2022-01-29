package pers.howard.personalspace.model;

/**
 * 偏好模组
 */
public class PreferenceItem {
    private String userID;
    private int backgroundColor;
    private int fontSize;

    public PreferenceItem(int backgroundColor, int fontSize) {
        this.backgroundColor = backgroundColor;
        this.fontSize = fontSize;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
