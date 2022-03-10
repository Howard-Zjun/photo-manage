package pers.howard.personalspace.model;

import lombok.Data;

@Data
public class PublishItem extends ShareItem{
    private String photoPath;

    public ShareItem exportShareItem() {
        ShareItem shareItem = new ShareItem();
        shareItem.userId = userId;
        shareItem.title = title;
        shareItem.sendDate = sendDate;
        shareItem.detail = detail;
        shareItem.tags = tags;
        shareItem.show = show;
        return shareItem;
    }
}
