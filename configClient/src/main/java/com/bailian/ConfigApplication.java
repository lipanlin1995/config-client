package com.bailian;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients(basePackages= {"com.bailian.feignClient"})
@EnableHystrix
@SpringBootApplication(scanBasePackages="com.bailian")
public class ConfigApplication {
    @Autowired  
    private RestTemplateBuilder builder;
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {  
        return builder.build();  
    }  
    
    public static void main( String[] args ){
        SpringApplication.run(ConfigApplication.class, args);
    }
}
