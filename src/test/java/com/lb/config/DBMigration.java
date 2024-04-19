package com.lb.config;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Profile("test")
public class DBMigration {


    @Autowired
    @Qualifier("inMemoryDS")
    DataSource dataSource;

    @PostConstruct
    public void migrateWithFlyway(){
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("db/migration")
                .load();
        flyway.repair();
        flyway.migrate();
    }

}
