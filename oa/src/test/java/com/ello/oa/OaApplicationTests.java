package com.ello.oa;

import com.ello.oa.domain.Test_dog;
import com.ello.oa.domain.Test_person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OaApplicationTests {

    @Autowired
    Test_person person;
    @Autowired
    Test_dog dog;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
