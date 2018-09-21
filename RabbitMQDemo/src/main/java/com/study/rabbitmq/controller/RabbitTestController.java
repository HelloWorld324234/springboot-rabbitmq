package com.study.rabbitmq.controller;

import com.study.rabbitmq.sender.HelloSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/9/21 0021 14:31
 * @Description:
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTestController {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;

    @PostMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

}
