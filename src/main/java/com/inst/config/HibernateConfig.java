package com.inst.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;



@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class HibernateConfig {

    @Value("${database.driverClassName}")
    private String driverClassName;

    @Value("${database.username}")
    private String username;

    @Value("${database.url}")
    private String url;

    @Value("${database.password}")
    private String password;

    @Value("${database.hibernate.dialect}")
    private String dialect;

    @Value("${database.hibernate.show_sql}")
    private String showSql;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername(password);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        return  dataSource;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan("com.inst");
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setDataSource(dataSource());
        sessionFactory.afterPropertiesSet();

        return  sessionFactory.getObject();
    }


    @Bean
    public HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return  transactionManager;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", dialect);
        hibernateProperties.put("hibernate.show_sql", showSql);

        return hibernateProperties;
    }



}
