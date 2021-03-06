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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/createjob", "/repair-log", "/create-user", "/add-vehicle", "/manager-landing-page").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/check-out-vehicle").access("hasRole('ROLE_USER')")
                .antMatchers("/check-in-vehicle", "/driver-landing-page").access("hasRole('ROLE_USER')")
                .antMatchers("/landingpage").access("hasRole('ROLE_USER')")
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