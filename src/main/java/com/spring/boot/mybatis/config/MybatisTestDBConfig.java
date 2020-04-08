package com.spring.boot.mybatis.config;

import com.spring.boot.mybatis.student.dao.StudentMapper;
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
@MapperScan(basePackageClasses = {StudentMapper.class},
        sqlSessionFactoryRef = "sqlSessionFactory2")
public class MybatisTestDBConfig
{

    @Autowired
    @Qualifier("testdb")
    private DataSource testdb;


    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception
    {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                                               .getResources("classpath:mapper/testdb/*.xml"));
        // 使用testDBa数据源, 连接testDBa库
        factoryBean.setDataSource(testdb);
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception
    {
        // 使用注解中配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2());
        return template;
    }
}