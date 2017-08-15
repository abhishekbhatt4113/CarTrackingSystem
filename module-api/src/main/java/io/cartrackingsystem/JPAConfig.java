package io.cartrackingsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean emf(){
        LocalContainerEntityManagerFactoryBean em=new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setPackagesToScan("io.cartrackingsystem.entity");
        Properties properties=new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.show_sql","true");
        em.setJpaProperties(properties);
        return em;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dm=new DriverManagerDataSource();
        dm.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dm.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dm.setUsername("hr");
        dm.setPassword("admin");
        return dm;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager txm=new JpaTransactionManager(emf);
        return txm;
    }


}
