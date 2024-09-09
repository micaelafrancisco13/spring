package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * The exclude attribute in @SpringBootApplication allows you to prevent specific autoconfiguration classes from being applied by
 *
 * Spring Boot. For example, if you want to exclude the DataSourceAutoConfiguration class to disable automatic configuration of a
 * data source (like when you're managing your own data source configuration), you would do something like this:
 *
 * @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
 *
 * */
@SpringBootApplication // @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
public class EazyschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazyschoolApplication.class, args);
    }

}
