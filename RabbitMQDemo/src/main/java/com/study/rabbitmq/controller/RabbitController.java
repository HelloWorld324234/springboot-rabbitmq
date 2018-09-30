package com.study.rabbitmq.controller;

import com.study.rabbitmq.sender.HelloSender;
import com.study.rabbitmq.sender.HelloSender2;
import com.study.rabbitmq.sender.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/9/30 0030 15:28
 * @Description:
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private HelloSender2 helloSender2;

    @Autowired
    private UserSender userSender;

    @PostMapping("/hello")
    public void hello() {
        helloSender.send();
    }

    @PostMapping("/onetomany")
    public String oneToMany() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i <= 10; i++) {
            String s = helloSender.sendMany("msg" + i);
            stringBuilder.append(s);
            stringBuilder.append("/r/n");
        }
        return stringBuilder.toString();
    }

    @PostMapping("/manytomany")
    public void manyToMany() {
        for(int i = 1; i <= 10; i++) {
            helloSender.send();
            helloSender2.send("helloSender2--->send--->");
        }
    }

    @PostMapping("/send_user")
    public void sendUser() {
        userSender.sendUser();
    }

}
