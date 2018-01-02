package com.bkap.vn.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.bkap.vn" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.bkap.vn.common.entity" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        /*<prop key="hibernate.jdbc.batch_size">50</prop>
                <prop key="hibernate.connection.useUnicode">true</prop>
                <prop key="hibernate.connection.charSet">utf8</prop>
                <prop key="hibernate.connection.autocommit">true</prop>
                <prop key="hibernate.connection.characterEncoding">utf8</prop>
                <prop key="hibernate.connection.release_mode">on_close</prop>
                <prop key="hibernate.c3p0.acquire_increment">1</prop>
                <prop key="hibernate.c3p0.idle_test_period">1800</prop>
                <prop key="hibernate.c3p0.max_size">100</prop>
                <prop key="hibernate.c3p0.max_statements">50</prop>
                <prop key="hibernate.c3p0.min_size">1</prop>
                <prop key="hibernate.c3p0.timeout">1800</prop>
                <prop key="hibernate.generate_statistics">false</prop>
                <prop key="hibernate.cache.use_second_level_cache">false</prop>
                <prop key="hibernate.cache.use_query_cache">false</prop>
                <prop key="hibernate.current_session_context_class">thread</prop>
                <prop key="cache.provider_class">org.hibernate.cache.NoCacheProvider</prop>
                <prop key="cache.use_minimal_puts">false</prop>*/
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        /*properties.put("hibernate.connection.useUnicode", environment.getRequiredProperty("hibernate.connection.useUnicode"));
        properties.put("hibernate.connection.charSet", environment.getRequiredProperty("hibernate.connection.charSet"));
        properties.put("hibernate.connection.autocommit", environment.getRequiredProperty("hibernate.connection.autocommit"));
        properties.put("hibernate.connection.characterEncoding", environment.getRequiredProperty("hibernate.connection.characterEncoding"));
        properties.put("hibernate.connection.release_mode", environment.getRequiredProperty("hibernate.connection.release_mode"));
        properties.put("hibernate.c3p0.acquire_increment", environment.getRequiredProperty("hibernate.c3p0.acquire_increment"));
        properties.put("hibernate.c3p0.idle_test_period", environment.getRequiredProperty("hibernate.c3p0.idle_test_period"));
        properties.put("hibernate.c3p0.max_size", environment.getRequiredProperty("hibernate.c3p0.max_size"));
        properties.put("hibernate.c3p0.max_statements", environment.getRequiredProperty("hibernate.c3p0.max_statements"));
        properties.put("hibernate.c3p0.min_size", environment.getRequiredProperty("hibernate.c3p0.min_size"));
        properties.put("hibernate.c3p0.timeout", environment.getRequiredProperty("hibernate.c3p0.timeout"));
        properties.put("hibernate.generate_statistics", environment.getRequiredProperty("hibernate.generate_statistics"));
        properties.put("hibernate.cache.use_second_level_cache", environment.getRequiredProperty("hibernate.cache.use_second_level_cache"));
        properties.put("hibernate.cache.use_query_cache", environment.getRequiredProperty("hibernate.cache.use_query_cache"));
        properties.put("hibernate.current_session_context_class", environment.getRequiredProperty("hibernate.current_session_context_class"));
        properties.put("cache.provider_class", environment.getRequiredProperty("cache.provider_class"));
        properties.put("cache.use_minimal_puts", environment.getRequiredProperty("cache.use_minimal_puts"));*/
        return properties;
    }

	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
}

