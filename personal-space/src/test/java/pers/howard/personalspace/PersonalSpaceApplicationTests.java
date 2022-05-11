package pers.howard.personalspace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.howard.personalspace.service.MongoService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class PersonalSpaceApplicationTests {

    @Autowired
    MongoService mongoService;

    @Test
    void contextLoads() throws FileNotFoundException {
        FileInputStream stream = new FileInputStream(new File("E:\\photo-manage\\personal-space\\src\\main\\resources\\static\\images\\image-detail.jpg"));
        mongoService.saveFile(stream, "blog-4.jpg", "image/jpeg");
    }

}
