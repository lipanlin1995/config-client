package com.bailian.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages= {"com.bailian"})
@SpringBootApplication(scanBasePackages="com.bailian")
public class ConfigApplication {
    
    public static void main( String[] args ){
        SpringApplication.run(ConfigApplication.class, args);
    }
}
