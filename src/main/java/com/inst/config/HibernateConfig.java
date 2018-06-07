package com.inst.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUsername("postgres");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/inst_db");
//        dataSource.setPassword("password");
        dataSource.setUsername("kylgovrtpsqxzs");
        dataSource.setUrl("jdbc:postgresql://ec2-79-125-110-209.eu-west-1.compute.amazonaws.com:5432/dahrnhfndrqi82");
        dataSource.setPassword("b23506a7f2dc2e34a2bf00b5cd94d6efc2ebaf8706f7ee63d39e7ccd25238fee");
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

    private static Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL92Dialect");
        hibernateProperties.put("hibernate.show_sql", "true");

        return hibernateProperties;
    }



}
