package com.example.rabbit.controller;

import com.example.rabbit.config.RabbitSenderConf;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class HelloReceive {

    /**
     * 该注解是监听队列的，当队列有消息的时候，它会自动获取。
     * 标注在类上面表示当有收到消息的时候，就交给 @RabbitHandler 的方法处理，具体使用哪个方法处理，根据 MessageConverter 转换后的参数类型
     */
    @RabbitListener(queues = RabbitSenderConf.QUEUE)
    public void receive(String msg) {
        System.err.println("消费者收到了一个消息 : " + msg + "  " + new Date().getTime());
    }

}
