package com.SMM.managementSystem.CONFIGURATION;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.lang.reflect.Member;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.SMM.managementSystem.DATA.assignment",
        entityManagerFactoryRef = "assignmentEntityManagerFactory",
        transactionManagerRef= "assignmentTransactionManager")
public class AssignmentDSC {
    @Bean
    @ConfigurationProperties("app.datasource.assignment")
    public DataSourceProperties assignmentDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("app.datasource.assignment.configuration")
    public DataSource assignmentDataSource() {
        return assignmentDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    @Bean(name = "assignmentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean assignmentEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(assignmentDataSource())
                .packages(Member.class)
                .build();
    }
    @Bean
    public PlatformTransactionManager memberTransactionManager(
            final @Qualifier("assignmentEntityManagerFactory") LocalContainerEntityManagerFactoryBean assignmentEntityManagerFactory) {
        return new JpaTransactionManager(assignmentEntityManagerFactory.getObject());
    }
}
