package pers.howard.personalspace.service;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public interface ResourceService {

    /**
     * 获取图片
     * @param id
     * @return
     */
    BufferedImage getImage(String id);

    void saveImage(InputStream inputStream, String filename, String contentType);
}
