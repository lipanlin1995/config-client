/**
 * 
 *	百联全渠道
 * Copyright (c) 2015-2018 BaiLian Technology co., LTD. All rights reserved.
 */
package com.bailian.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author lipanlin
 * @version 1.0:2018年5月4日 上午10:52:53
 */
@RestController
@RefreshScope
public class DemoController {
    @Value("${spring.kafka.host}")
    private String host; 
    
    @RequestMapping("/hello")
    public String hello() {
        return host;
    }
}
