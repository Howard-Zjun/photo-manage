package pers.howard.personalspace.model;

import lombok.Data;

@Data
public class ShareItem {
    protected String shareId;
    protected String userId;
    protected String title;
    protected String sendDate;
    protected String detail;
    protected String tags;
    protected int show;
}
