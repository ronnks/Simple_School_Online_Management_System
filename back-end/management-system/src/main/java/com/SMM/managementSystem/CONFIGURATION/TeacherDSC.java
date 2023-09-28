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
@EnableJpaRepositories(basePackages = "com.SMM.managementSystem.DATA.teacher",
        entityManagerFactoryRef = "teacherEntityManagerFactory",
        transactionManagerRef= "teacherTransactionManager")
public class TeacherDSC {
    @Bean
    @ConfigurationProperties("app.datasource.teacher")
    public DataSourceProperties teacherDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("app.datasource.teacher.configuration")
    public DataSource teacherDataSource() {
        return teacherDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    @Bean(name = "memberEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean teacherEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(teacherDataSource())
                .packages(Member.class)
                .build();
    }
    @Bean
    public PlatformTransactionManager teacherTransactionManager(
            final @Qualifier("teacherEntityManagerFactory") LocalContainerEntityManagerFactoryBean teacherEntityManagerFactory) {
        return new JpaTransactionManager(teacherEntityManagerFactory.getObject());
    }
}
