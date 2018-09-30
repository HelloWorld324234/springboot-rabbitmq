package com.study.rabbitmq.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: yule
 * @Date: 2018/9/30 0030 14:47
 * @Description: Topic Exchange 队列
 *
 * Topic类型的exchange就像一个直接的交换：一个由生产者指定了确定routing key的消息将会被推送给所有Binding key能与之匹配的消费者。然而这种绑定有两种特殊的情况：
 * <p>
 *  *（星号）：可以（只能）匹配一个单词
 *  #（井号）：可以匹配多个单词（或者零个）
 * </p>
 *
 */
@Configuration
public class TopicQueueSender {

    private final static String queue = "helloQueue";

    private final static String user = "user";

    @Bean
    public Queue helloQueue() {
        return new Queue(queue);
    }

    @Bean
    public Queue userQueue() {
        return new Queue(user);
    }

    //===============以下是验证topic Exchange的队列==========
    @Bean
    public Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     *
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    /**
     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     *
     * @param queueMessages
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}










