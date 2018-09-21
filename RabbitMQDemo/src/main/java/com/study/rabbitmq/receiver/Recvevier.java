package com.study.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.study.rabbitmq.Constants;
import com.study.rabbitmq.utils.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: yule
 * @Date: 2018/9/21 0021 15:06
 * @Description: 接受duan
 */
public class Recvevier {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //1、创建连接
        Connection connection = RabbitMQUtil.getConnectionFactory(Constants.localhost);

        //2、创建通道
        Channel channel = connection.createChannel();
        //确保队列是存在的
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.err.println("Waiting for messages. To exit press CTRL+C");

        /*这里用到了额外的类QueueingConsumer来缓存服务器将要推过来的消息。我们通知服务器向接收端推送消息，
　　　   然后服务器将会向客户端异步推送消息，这里提供了一个可以回调的对象来缓存消息，直到我们做好准备来使用
　　     它，这个类就是QueueingConsumer*/
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }

    }

}
