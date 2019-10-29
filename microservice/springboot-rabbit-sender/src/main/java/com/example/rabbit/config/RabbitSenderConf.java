package com.example.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类初始化创建队列、转发器，并把队列绑定到转发器
 */
@Configuration
public class RabbitSenderConf {

    public static final String QUEUE = "queue";

    /**
     * 创建一个队列
     * Queue 可以有4个参数
     *      1.队列名
     *      2.durable       持久化消息队列，rabbitMQ重启的时候不需要创建新的队列，默认true
     *      3.auto-delete   表示消息队列没有在使用时将被自动删除，默认是false
     *      4.exclusive     表示该消息队列是否只在当前connection生效，默认是false
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }

}
