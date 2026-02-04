package com.retailops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        exclude = {
                UserDetailsServiceAutoConfiguration.class
        }
)
@EnableJpaRepositories(basePackages = "com.retailops.repository")
@EntityScan(basePackages = "com.retailops.entity")
public class RetailOpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailOpsApplication.class, args);
    }
}
