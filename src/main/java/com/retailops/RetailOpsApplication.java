package com.retailops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.retailops.repository")
@EntityScan(basePackages = "com.retailops.entity")
public class RetailOpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailOpsApplication.class, args);
    }
}
