package pers.howard.personalspace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.howard.personalspace.service.MongoService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
class PersonalSpaceApplicationTests {

    @Autowired
    MongoService mongoService;

    @Test
    void contextLoads() {
        String pare = "C:\\Users\\心里的潇洒情\\Desktop\\新建文件夹 (2)\\images";
        String[] arr = {"blog-1.jpg", "blog-2.jpg", "blog-3.jpg", "blog-4.jpg", "1-nature.jpg", "2-nature.jpg", "4-nature.jpg"};
        try {
            for (String temp : arr) {
                File file = new File(pare + "\\" + temp);
                FileInputStream fileInputStream = new FileInputStream(file);
                mongoService.saveFile(fileInputStream, file.getName(), "image/jpeg");
            }

        } catch (IOException e) {}
    }

}
