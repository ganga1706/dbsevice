package com.lb;

import com.lb.config.DBConfig;
import com.lb.config.DBMigration;
import com.lb.dbservice.rest.DbController;
import com.lb.dbservice.rest.model.UserRequest;
import com.lb.dbservice.rest.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ComponentScan(basePackages = {"com.lb.dbservice.*"})
@SpringBootTest(classes = {DBConfig.class, DBMigration.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class DbserviceApplicationIntegrationTests extends AbstractTestNGSpringContextTests {

    @Autowired
    DbController dbController;

    @Test
    void contextLoads() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("Un");
        userRequest.setPhNumber("212e32");
        userRequest.setEmail("email");
        userRequest.setPassword("123");

		UserResponse user = dbController.createUser(userRequest);
		System.out.println(user);
	}

}
