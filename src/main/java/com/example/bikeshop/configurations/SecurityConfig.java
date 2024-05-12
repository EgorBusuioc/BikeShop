package com.example.bikeshop.configurations;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/registration", "/login", "/choose_your_bike/**",
                                "/bikes", "/active_bikes", "/mountain_bikes", "/road_bikes", "/turbo_bikes", "/sworks_bikes", "/components", "/equipments",
                                "/static/**", "/images/**", "/error", "/invalid-url/**").permitAll()
                        .requestMatchers("/product_details/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/add_product", "/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/choose_your_bike/**").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}