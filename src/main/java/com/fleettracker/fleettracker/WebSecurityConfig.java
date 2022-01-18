package com.fleettracker.fleettracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/createjob").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("user")
                .password(encoder().encode("password"))
                .roles("USER").build());
        manager.createUser(User
                .withUsername("driver1")
                .password(encoder().encode("password1"))
                .roles("USER").build());
        manager.createUser(User
                .withUsername("driver2")
                .password(encoder().encode("password2"))
                .roles("USER").build());
        manager.createUser(User
                .withUsername("driver3")
                .password(encoder().encode("password3"))
                .roles("USER").build());
        manager.createUser(User
                .withUsername("admin")
                .password(encoder().encode("adminPass"))
                .roles("ADMIN").build());
        return manager;
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}