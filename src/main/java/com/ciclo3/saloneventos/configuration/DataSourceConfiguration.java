package com.ciclo3.saloneventos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration{
    @Value("${spring.datasource.url}")
    private String dataUrl;
    
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    
    @Value("${spring.datasource.username}")
    private String username;
    
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource datasource(){
        return DataSourceBuilder.create()
            .url(dataUrl)
            .driverClassName(driver)
            .username(username)
            .password(password)
            .build(); 
    }
}
