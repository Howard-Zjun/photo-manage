package pers.howard.personalspace.model;

import lombok.Data;

@Data
public class LikeItem {
    private String userId;
    private String shareId;
    public LikeItem() {}
    public LikeItem(String shareId, String userId) {
        this.shareId = shareId;
        this.userId = userId;
    }
}
