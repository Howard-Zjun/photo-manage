package pers.howard.personalspace.model;

/**
 * 评论模型
 */
public class RemarkItem {
    private String name;
    private String detail;

    public RemarkItem(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
