package com.java.spring.config;

import com.java.spring.security.AuthenticationProviderService;
import com.java.spring.security.MyPasswordEncoder;
import com.java.spring.security.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationProviderService authenticationProvider;

    @Autowired
    WebSecurityConfig (AuthenticationProviderService authenticationProvider){
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new MyPasswordEncoder();
    }

    public AuthenticationFilter requestValidationFilter() throws Exception {
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationSuccessHandler(successHandler());
        return filter;
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider);
    }

    public SimpleUrlAuthenticationSuccessHandler successHandler() {
        return new SimpleUrlAuthenticationSuccessHandler("/main");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .defaultSuccessUrl("/main", true)
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .invalidateHttpSession(true)
                    .and()
                .httpBasic().disable();
                http.addFilterBefore(
                        requestValidationFilter(),
                UsernamePasswordAuthenticationFilter.class);
    }
}
