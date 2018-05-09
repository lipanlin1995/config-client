package com.bailian;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableFeignClients(basePackages= {"com.bailian.feignClient"})
@EnableHystrix
@SpringBootApplication(scanBasePackages="com.bailian")
public class ConfigApplication {
    
    public static void main( String[] args ){
        SpringApplication.run(ConfigApplication.class, args);
    }
}
