package com.serhatacar.restaurantservice.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Swagger OpenAPI configuration class
 * /
 * @author Serhat Acar
 */
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "Serhat Acar", email = "sserhatacarr@gmail.com"),
                description = "OpenAPI documentation for Dine Experience App, a Spring Boot REST API as a graduation project for n11 TalentHub Bootcamp",
                title = " Dine Experience App - Restaurant Service API",
                version = "1.0"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Source code on GitHub",
                url = "https://www.github.com/sserhatacarr/dineExperienceApp"
        ),
        servers = {@Server(description = "restaurant-service", url = "https://localhost:8080")}

)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerOpenAPIConfig {
}