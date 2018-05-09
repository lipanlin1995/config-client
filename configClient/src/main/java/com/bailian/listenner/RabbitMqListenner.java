/**
 * 
 *	百联全渠道
 * Copyright (c) 2015-2018 BaiLian Technology co., LTD. All rights reserved.
 */
package com.bailian.listenner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * rabbitMq监听器
 * @author lipanlin
 * @version 1.0:2018年5月7日 下午4:08:50
 */
@Component
@RabbitListener(queues = "test")
public class RabbitMqListenner {
    private Logger logger = LoggerFactory.getLogger(RabbitMqListenner.class);
    @RabbitHandler
    public void process(String msg) {
        logger.info("接收到rabbitMq消息:" + msg);
    }
}
