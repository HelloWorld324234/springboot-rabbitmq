package com.study.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yule
 * @Date: 2018/9/30 0030 15:42
 * @Description:
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String msg) {
        System.err.println("HelloReceiver2--->" + msg);
    }

}
