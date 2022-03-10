package pers.howard.personalspace.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.howard.personalspace.service.ResourceService;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/resource")
@Slf4j
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getImage(@RequestParam("id") String id) {
        return resourceService.getImage(id);
    }

    @PostMapping("/upload")
    @ResponseBody
    public String saveImage(@RequestParam("image") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            return resourceService.saveImage(inputStream, file.getOriginalFilename(), file.getContentType());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
