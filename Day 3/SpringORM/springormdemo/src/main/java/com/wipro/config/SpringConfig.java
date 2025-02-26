package com.wipro.config;

//mainly used for the database connection,hibernate setup,and transaction management
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.wipro")
public class SpringConfig {

    @Bean
    public DataSource dataSource()//defines the database connesntion
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/wipro");
        ds.setUsername("root");
        ds.setPassword("#Mahadev7");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.wipro.entity");  // Fix incorrect package path

        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect"); // Fix deprecated dialect
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "true");

        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    // ✅ Add this missing TransactionManager bean
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
