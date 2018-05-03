package com.bailian.config.client.configClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigApplication {
    public static void main( String[] args ){
        SpringApplication.run(ConfigApplication.class, args);
    }
    
    @Autowired
    private Environment environment;
    
    @Value("${spring.kafka.host}")
    private String host; 
    
    @RequestMapping("/hello")
    public String home() {
        return host;
    }
}
