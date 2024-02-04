package com.fitness.app.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
  private static final String[] AUTH_WHITELIST = {
      "/swagger-resources",
      "/swagger-resources/**",
      "/swagger-ui.html",
      "/webjars/**",
      "/v3/api-docs/**",
      "/swagger-ui/**"
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(AUTH_WHITELIST).permitAll()
            .anyRequest().permitAll()
        )
        .httpBasic(withDefaults());
    return http.build();
  }

}
