package com.study.rabbitmq.sender;

import com.study.rabbitmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yule
 * @Date: 2018/9/30 0030 16:31
 * @Description:
 */
@Component
public class UserSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void sendUser() {
        User user = new User();
        user.setName("Tom");
        user.setAddress("HK");
        this.amqpTemplate.convertAndSend("userQueue", user);
    }

}
