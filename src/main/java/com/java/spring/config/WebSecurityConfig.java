package com.java.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // (1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {  // (2)
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll() // (3)
                    .anyRequest().authenticated() // (4)
                    .and()
                .formLogin().disable() // (5)
                    //.loginPage("/login") // (5)
                    //.permitAll()
                    //.and()
                .logout() // (6)
                    .permitAll()
                    .invalidateHttpSession(true)
                    .and()
                .httpBasic(); // (7)
    }
    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

}
