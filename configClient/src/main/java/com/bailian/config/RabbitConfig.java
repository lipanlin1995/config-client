package com.bailian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

/**
 * 配置rabbitMq队列名称
 * @author lipanlin
 * @version 1.0:2018年5月7日 下午4:15:32
 */
@Configuration
public class RabbitConfig {
    /**
     * 队列名称
     */
    private static final String QUEUE = "test";
    
    @Bean
    public Queue Queue() {
        return new Queue(QUEUE);
    }

}