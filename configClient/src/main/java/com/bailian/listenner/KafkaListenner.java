/**
 * 
 *	百联全渠道
 * Copyright (c) 2015-2018 BaiLian Technology co., LTD. All rights reserved.
 */
package com.bailian.listenner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author lipanlin
 * @version 1.0:2018年5月7日 下午2:52:26
 */
@Component
public class KafkaListenner {
    private Logger logger = LoggerFactory.getLogger(KafkaListenner.class);

    @KafkaListener(topics = "test")
    public void content(String msg){
        logger.info("接受到的消息:{}", msg);
    }
}
