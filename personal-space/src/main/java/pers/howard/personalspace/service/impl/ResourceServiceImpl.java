package pers.howard.personalspace.service.impl;

import org.springframework.stereotype.Service;
import pers.howard.personalspace.service.ResourceService;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.io.InputStream;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Resource
    MongoServiceImpl photoServiceImpl;

    @Override
    public BufferedImage getImage(String id) {
        return photoServiceImpl.getImage(id);
    }

    @Override
    public String saveImage(InputStream inputStream, String filename, String contentType) {
        return photoServiceImpl.saveFile(inputStream, filename, contentType);
    }
}
