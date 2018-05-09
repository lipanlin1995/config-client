package com.bailian.feignClient.fallBack;

import org.springframework.stereotype.Component;

import com.bailian.feignClient.DemoFeignService;


@Component
public class HystrixClientFallback implements DemoFeignService {

    /** 
     * @see com.bailian.feignClient.DemoFeignService#hello()
     */
    @Override
    public String hello() {
        return "invoke fail!";
    }

}