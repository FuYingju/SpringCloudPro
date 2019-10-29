package com.example.rabbit.controller;

import com.example.rabbit.config.RabbitSenderConf;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloSender {

    @Autowired
    private AmqpTemplate template;

    @GetMapping("/send")
    public void send(String msg) {
        // 将消息队列存入rabbitMQ的消息队列里
        template.convertAndSend(RabbitSenderConf.QUEUE, msg);
        System.err.println("生产者生产了一个消息 : " + msg + "  " + new Date().getTime());
    }

}
