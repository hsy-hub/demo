package com.example.demo.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DBCPDataSourceConfig {
    @Bean(value = "dataSource")
    public DataSource getDataSource() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("driverClassName","com.mysql.jdbc.Driver");
        properties.setProperty("password","123456");
        properties.setProperty("username","root");
        properties.setProperty("url","jdbc:mysql://localhost:3306/test?characterEncoding=utf-8");
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        return dataSource;

    }

}
