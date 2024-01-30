package com.fitness.app.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Value("${openapi.dev-url:test}")
  private String devUrl;

  @Value("${openapi.prod-url:test}")
  private String prodUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("Server URL in Production environment");

    Contact contact = new Contact();
    contact.setEmail("muhamed.s.vrajolli@gmail.com");
    contact.setName("Muhamed Vrajolli");

    Info info = new Info()
        .title("Workout Management API")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to manage fitness workout plans.");

    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
  }
}
