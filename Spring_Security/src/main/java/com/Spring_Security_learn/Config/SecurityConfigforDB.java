package com.Spring_Security_learn.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfigforDB
{
//@EnableMethodSecurity(prePostEnabled = true)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

          http.authorizeHttpRequests(//
                  request -> request.requestMatchers("/api/route2","/application/ProductViwe" ,"/application/Category_Viwe").hasRole("NORMAL")
                          .requestMatchers("/application/ProductAdd","/application/CategoryAdd","api/route1","/api/route2" ).hasRole("ADMIN")
                          .anyRequest().permitAll()

          );
          http.formLogin(Customizer.withDefaults());
          http.httpBasic(Customizer.withDefaults());
        return http.build();
    }



}
