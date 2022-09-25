package com.spring.boot.mybatis.config;

import com.spring.boot.mybatis.student.dao.StudentMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by Jay on 2020/4/8
 */
@Configuration
@MapperScan(basePackageClasses = {StudentMapper.class},
        sqlSessionFactoryRef = "sqlSessionFactoryForTestdb")
public class MybatisTestDBConfig
{

    @Autowired
    @Qualifier("dataSourceForTestdb")
    private DataSource dataSourceForTestdb;


    @Bean
    public SqlSessionFactory sqlSessionFactoryForTestdb()
            throws Exception
    {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        List<Resource> resources = new ArrayList<>();

        Resource[] resources1 = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/test/*.xml");
        resources.addAll(Arrays.asList(resources1));
        Resource[] resources2 = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/testdb/*.xml");
        resources.addAll(Arrays.asList(resources2));
        Resource[] resources3 = new Resource[resources1.length + resources2.length];
        factoryBean.setMapperLocations(resources.toArray(resources3));
        // 使用testDBa数据源, 连接testDBa库
        factoryBean.setDataSource(dataSourceForTestdb);
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2()
            throws Exception
    {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryForTestdb());
        return template;
    }
}