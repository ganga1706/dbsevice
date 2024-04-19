package com.lb.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//this is main class
@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = {"com.lb.dbservice.*"})
@TestPropertySource(properties = "classpath*:application.properties")
@ExtendWith(SpringExtension.class)
public class DbserviceApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(DbserviceApplicationTest.class, args);
	}

}
