package com.lb.config;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.security.SecureRandom;
import java.util.Random;

@SpringBootApplication
@EnableWebMvc
@TestConfiguration
@ComponentScan("com.lb.dbservice.*")
@EnableJpaRepositories(basePackages = {"com.lb.dbservice.repository","com.lb.dbservice.entity"}, entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
@Profile("test")
public class DBConfig {

    @Autowired
    private Environment env;

    @PostConstruct
    private void init() {
//        System.setProperty("mifare_aes_encryption_key", "YqPeabr952yAbEHPXTenDTlNmimBUiba");
//        com.nxp.mifare.util.Properties.getProperties().setEnv(this.env);
//        com.nxp.service.util.Properties.getProperties().setEnv(this.env);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Qualifier("inMemoryDS")
    @FlywayDataSource
    public DataSource inMemoryDS() throws Exception {
        Random port = new SecureRandom();
        DataSource embeddedPostgresDS =
//                EmbeddedPostgres.builder().setPort(port.nextInt(65535)).start().getPostgresDatabase();
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .build();
        return embeddedPostgresDS;
    }

    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.H2);
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);
        return vendorAdapter;
    }

    @Primary
    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean entityManager =
                new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(inMemoryDS());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter());
        entityManager.setPackagesToScan("com.lb.dbservice.entity","com.lb.dbservice.repository");

        return entityManager;
    }

    @Bean(name = {"transactionManager", "transactionManagerSPDB"})
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        transactionManager.setDataSource(inMemoryDS());
        return transactionManager;
    }
}
