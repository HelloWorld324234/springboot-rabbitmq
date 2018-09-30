package com.study.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yule
 * @Date: 2018/9/30 0030 16:14
 * @Description:
 */
@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        System.err.println("HelloSender2--->" + msg);
        this.amqpTemplate.convertAndSend("helloQueue", msg);
    }

}
