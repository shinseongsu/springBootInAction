package com.example;

import com.example.controller.BoardController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= BoardController.class,
                properties = {"author.name=Gurum",
                              "author.age=45",
                              "author.nation=Korea"})
public class SpringExampleApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void contextLoads() {
        System.out.println("이름 : " + environment.getProperty("author.name"));
        System.out.println("나이 : " + environment.getProperty("author.age"));
        System.out.println("국각 : " + environment.getProperty("author.nation"));
    }
}