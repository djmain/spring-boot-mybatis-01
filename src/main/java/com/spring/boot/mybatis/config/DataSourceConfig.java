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

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource dataSourceForTest()
    {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.testdb")
    public DataSource dataSourceForTestdb()
    {
        return DataSourceBuilder.create().build();
    }

}