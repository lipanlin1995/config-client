/**
 * 
 *	百联全渠道
 * Copyright (c) 2015-2018 BaiLian Technology co., LTD. All rights reserved.
 */
package com.bailian.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bailian.feignClient.fallBack.HystrixClientFallback;


/**
 * 
 * @author lipanlin
 * @version 1.0:2018年5月4日 上午11:01:43
 */
@FeignClient(value = "myConfig", fallback = HystrixClientFallback.class)
public interface DemoFeignService {
    
    @RequestMapping(value = "/myConfig/demo/hello")
    public String hello();
    
}
