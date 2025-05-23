package com.sprms.microservices.product.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI prodServerAPI() {
        return new OpenAPI()
                .info(new Info().title("Product API - XYZ").description("rest api for prod service"))
                .externalDocs(new ExternalDocumentation()
                        .description("you can refer to here....").url("https://prodservice-dumm.com/docs"));
    }
}
