package pers.howard.personalspace.model;

import lombok.Data;

@Data
public class ImageItem {
    private int id;
    private byte[] bytes;

    public ImageItem() {}

    public ImageItem(int id, byte[] bytes) {
        this.id = id;
        this.bytes = bytes;
    }
}
