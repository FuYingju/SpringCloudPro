package com.example.rabbit.test;

import com.example.rabbit.RabbitSenderApplication;
import com.example.rabbit.controller.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes= RabbitSenderApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSender {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }

}
