package com.isspu.test.config;

import com.isspu.test.config.Properties.DataProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;


/**
 * Created by linwx on 2017/2/7.
 */

@Configuration
@EnableConfigurationProperties(DataProperties.class)
public class MyBatisConfig {
    @Autowired
    private DataProperties dataProperties;
    private final static String mapperLocations = "classpath:dao/*.xml";

    private org.apache.tomcat.jdbc.pool.DataSource pool;

    @RefreshScope
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        this.pool = new org.apache.tomcat.jdbc.pool.DataSource();
        this.pool.setDriverClassName(dataProperties.getDriverClassName());
        this.pool.setUrl(dataProperties.getUrl());
        if (dataProperties.getUsername() != null) {
            this.pool.setUsername(dataProperties.getUsername());
        }
        if (dataProperties.getPassword() != null) {
            this.pool.setPassword(dataProperties.getPassword());
        }
        this.pool.setInitialSize(dataProperties.getInitialSize());
        this.pool.setMaxActive(dataProperties.getMaxActive());
        this.pool.setMaxIdle(dataProperties.getMaxIdle());
        this.pool.setMinIdle(dataProperties.getMinIdle());
        this.pool.setTestOnBorrow(dataProperties.isTestOnBorrow());
        this.pool.setTestOnReturn(dataProperties.isTestOnReturn());
        this.pool.setValidationQuery(dataProperties.getValidationQuery());
        return this.pool;
    }

    @PreDestroy
    public void close() {
        if (this.pool != null) {
            this.pool.close();
        }
    }
}
