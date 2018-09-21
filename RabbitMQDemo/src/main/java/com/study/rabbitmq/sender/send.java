package com.study.rabbitmq.sender;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.rabbitmq.Constants;
import com.study.rabbitmq.utils.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: yule
 * @Date: 2018/9/21 0021 14:58
 * @Description: 发送端
 */
public class send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建连接
        /*连接可以抽象为socket连接，为我们维护协议版本信息和协议证书等。这里我们连接
        上了本机的消息服务器实体（localhost）。如果我们想连接其它主机上的RabbitMQ服务，只需要修改一下主机名或是IP就可以了*/
        Connection connection = RabbitMQUtil.getConnectionFactory(Constants.localhost);

        //2、创建消息通道
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String msg = "HelloWorld";
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        System.err.println("send---->" + msg);

        //3、关闭连接
        channel.close();
        connection.close();

    }

}
