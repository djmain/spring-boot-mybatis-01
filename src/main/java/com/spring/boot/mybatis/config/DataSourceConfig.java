package com.spring.boot.mybatis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * created by Jay on 2020/4/8
 */
@Configuration
public class DataSourceConfig
{

    @Bean(name = "test")
    // application.properteis中对应属性的前缀
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource dataSource1()
    {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "testdb")
    // application.properteis中对应属性的前缀
    @ConfigurationProperties(prefix = "spring.datasource.testdb")
    public DataSource dataSource2()
    {
        return DataSourceBuilder.create().build();
    }

}