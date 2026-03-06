package com.retailops.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI retailOpsAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RetailOps Backend API")
                        .description("Backend platform for cart, orders, and inventory management")
                        .version("1.0"));
    }
}
