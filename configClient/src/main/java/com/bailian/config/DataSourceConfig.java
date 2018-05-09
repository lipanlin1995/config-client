/**
 * 
 *	百联全渠道
 * Copyright (c) 015-018 BaiLian Technology co., LTD. All rights reserved.
 */
package com.bailian.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {
    @Value("${spring.dataSource.username}")
    private String user;

    @Value("${spring.dataSource.password}")
    private String password;

    @Value("${spring.dataSource.url}")
    private String dataSourceUrl;

    @Value("${spring.dataSource.driver-class-name}")
    private String driverClassName;
    
    @Value("${spring.dataSource.maxActive}")
    private int maxActive;

    @Value("${spring.dataSource.initialSize}")
    private int initialSize;
    
    @Value("${spring.dataSource.maxWait}")
    private int maxWait;
    
    @Value("${spring.dataSource.minIdle}")
    private int minIdle;
    
    @Value("${spring.dataSource.connectionTimeout}")
    private int connectionTimeout;

    public DataSourceConfig() {

    }

    @Bean
    public DruidDataSource getdataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(this.driverClassName);
        ds.setUsername(this.user);
        ds.setPassword(this.password);
        ds.setUrl(this.dataSourceUrl);
        ds.setInitialSize(this.initialSize);
        ds.setMinIdle(this.minIdle);
        ds.setMaxActive(this.maxActive);
        return ds;
    }
}
