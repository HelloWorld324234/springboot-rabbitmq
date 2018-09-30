package com.study.rabbitmq.receiver;

import com.study.rabbitmq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yule
 * @Date: 2018/9/30 0030 16:34
 * @Description:
 */
@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {

    @RabbitHandler
    public void process(User user) {
        System.err.println("UserReceiver--->" + user.toString());
    }

}
