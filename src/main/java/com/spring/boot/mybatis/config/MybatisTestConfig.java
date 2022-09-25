package com.spring.boot.mybatis.config;

import com.spring.boot.mybatis.person.dao.BookMapper;
import com.spring.boot.mybatis.person.dao.PersonMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * created by Jay on 2020/4/8
 */
@Configuration
@MapperScan(
        basePackageClasses = {PersonMapper.class},
        sqlSessionFactoryRef = "sqlSessionFactoryForTest")
public class MybatisTestConfig
{

    @Autowired
    @Qualifier("dataSourceForTest")
    private DataSource dataSourceForTest;


    @Bean
    public SqlSessionFactory sqlSessionFactoryForTest() throws Exception
    {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                                               .getResources("classpath:mapper/test/*.xml"));
        // 使用testDBa数据源, 连接testDBa库
        factoryBean.setDataSource(dataSourceForTest);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateForTest() throws Exception
    {
        // 使用注解中配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryForTest());
        return template;
    }
}