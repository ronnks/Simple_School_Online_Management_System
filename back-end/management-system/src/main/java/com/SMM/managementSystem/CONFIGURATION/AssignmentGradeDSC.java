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
@EnableJpaRepositories(basePackages = "com.SMM.managementSystem.DATA.assignmentGrade",
        entityManagerFactoryRef = "assignment-gradeEntityManagerFactory",
        transactionManagerRef= "assignment-gradeTransactionManager")
public class AssignmentGradeDSC {
    @Bean
    @ConfigurationProperties("app.datasource.assignment-grade")
    public DataSourceProperties assignmentGradeDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("app.datasource.assignment-grade.configuration")
    public DataSource assignmentGradeDataSource() {
        return assignmentGradeDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    @Bean(name = "assignment-gradeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean assignmentGradeEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(assignmentGradeDataSource())
                .packages(Member.class)
                .build();
    }
    @Bean
    public PlatformTransactionManager assignmentGradeTransactionManager(
            final @Qualifier("assignment-gradeEntityManagerFactory") LocalContainerEntityManagerFactoryBean assignmentGradeEntityManagerFactory) {
        return new JpaTransactionManager(assignmentGradeEntityManagerFactory.getObject());
    }
}
