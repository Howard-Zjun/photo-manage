package pers.howard.personalspace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.howard.personalspace.service.MongoService;

@SpringBootTest
class PersonalSpaceApplicationTests {

    @Autowired
    MongoService mongoService;

    @Test
    void contextLoads() {
    }

}
