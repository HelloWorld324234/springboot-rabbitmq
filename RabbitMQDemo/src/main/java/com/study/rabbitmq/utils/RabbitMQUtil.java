package com.study.rabbitmq.utils;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * @Auther: yule
 * @Date: 2018/9/21 0021 15:11
 * @Description: rabbitmq 工具类
 */
public class RabbitMQUtil {

    /**
     * 创建连接
     *
     * @param hostAddress 要连接的主机地址
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getConnectionFactory(String hostAddress) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(hostAddress);
        return factory.newConnection();
    }

}
