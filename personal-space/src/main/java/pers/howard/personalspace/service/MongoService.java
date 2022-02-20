package pers.howard.personalspace.service;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public interface MongoService {

    /**
     * 自增id
     * @return 键id
     */
    int increaseId();

    /**
     * 保存图片
     * @param inputStream
     * @param filename
     * @param contentType
     * @return
     */
    String saveFile(InputStream inputStream, String filename, String contentType);

    /**
     * 获取图片
     * @param id
     * @return
     */
    BufferedImage getImage(String id);
}
