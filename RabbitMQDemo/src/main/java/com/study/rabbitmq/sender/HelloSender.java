package com.study.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: yule
 * @Date: 2018/9/30 0030 15:04
 * @Description: 生产者
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String msg = "Hello " + new Date().toString();
        System.err.println("HelloSender--->" + msg);
        this.amqpTemplate.convertAndSend("helloQueue", msg);
    }

    public String sendMany(String str) {
        String msg = "Hello : " + str + "  " + new Date().toString();
        System.err.println("HelloSender--->" + msg);
        this.amqpTemplate.convertAndSend("helloQueue", msg);
        return msg;
    }

}
