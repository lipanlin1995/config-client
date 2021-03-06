/**
 * 
 *	百联全渠道
 * Copyright (c) 2015-2018 BaiLian Technology co., LTD. All rights reserved.
 */
package com.bailian.controller;


import java.net.URI;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bailian.feignClient.DemoFeignService;

/**
 * 
 * @author lipanlin
 * @version 1.0:2018年5月4日 上午10:52:53
 */
//此注解用于刷新远程配置
@RefreshScope
@RestController
@RequestMapping("/demo")
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(DemoController.class);
    
    @Autowired
    private DemoFeignService demoFeignService;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate; 
    
    
    @Value("${spring.kafka.consumer.servers}")
    private String servers;
    
    @RequestMapping("/hello")
    public String hello() {
        return servers;
    }
    
    @RequestMapping("/testFeign")
    public String testFeign(){
        return this.demoFeignService.hello();
    }
    
    @RequestMapping("/sendMsg")
    public String sendMsg(){
        String context = "hello-" + new Date();
        logger.info("发送rabbitMq消息:" + context);
        amqpTemplate.convertAndSend("test", context);
        return "ok";
    }
    
    
    @RequestMapping("/ribbonFindUser")
    public String ribbonFindUser(){
        ServiceInstance instance = this.loadBalancerClient.choose("myConfigA");
        URI helloUri = URI.create(String.format("http://%s:%s/myConfigA/user/getUserInfo", instance.getHost(), instance.getPort()));        
        logger.info("Target service uri = {}", helloUri.toString());
        return new RestTemplate().getForObject(helloUri, String.class);
    }
}
