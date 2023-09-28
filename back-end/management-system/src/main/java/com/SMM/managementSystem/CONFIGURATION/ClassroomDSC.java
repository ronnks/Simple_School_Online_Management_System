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
@EnableJpaRepositories(basePackages = "com.SMM.managementSystem.DATA.classroom",
        entityManagerFactoryRef = "classroomEntityManagerFactory",
        transactionManagerRef= "classroomTransactionManager")
public class ClassroomDSC {
    @Bean
    @ConfigurationProperties("app.datasource.classroom")
    public DataSourceProperties classroomDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("app.datasource.classroom.configuration")
    public DataSource classroomDataSource() {
        return classroomDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    @Bean(name = "classroomEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean classroomEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(classroomDataSource())
                .packages(Member.class)
                .build();
    }
    @Bean
    public PlatformTransactionManager classroomTransactionManager(
            final @Qualifier("assignmentEntityManagerFactory") LocalContainerEntityManagerFactoryBean classroomEntityManagerFactory) {
        return new JpaTransactionManager(classroomEntityManagerFactory.getObject());
    }
}
