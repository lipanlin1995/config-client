package com.bailian.config.client.configClient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
@RestController
public class ConfigApplication {
    public static void main( String[] args ){
        SpringApplication.run(ConfigApplication.class, args);
    }
    
    @Value("${spring.kafka.host}")
    private String host; 
    
    @RequestMapping("/hello")
    public String home() {
        return host;
    }
}
