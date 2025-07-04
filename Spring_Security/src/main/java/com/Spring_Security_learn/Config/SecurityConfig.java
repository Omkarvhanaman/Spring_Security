package com.Spring_Security_learn.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig
{
@Bean
public UserDetailsService userDetailsService()
{
    UserDetails user1= User.withDefaultPasswordEncoder()
            .username("omkar")
            .password("omkar111")
            .build();
    UserDetails user2= User.withDefaultPasswordEncoder()
            .username("snehal")
            .password("snehal111")
            .build();
    InMemoryUserDetailsManager inMemoryUserDetailsManager =new InMemoryUserDetailsManager(user1,user2);
    return inMemoryUserDetailsManager;

    /*
    if u not use password Encoder then .IllegalArgumentException: Given that there is no default password encoder configured come

    solution without encode use =  withDefaultPasswordEncoder()
                             or
     password encoder methoed create .

     */
}

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
