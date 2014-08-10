/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author campitos
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
          
            .anyRequest().authenticated()   
            .and()
        .formLogin()
            .loginPage("/servicios/login") 
            .permitAll()
            .and()
            .logout()
                .permitAll()
            .deleteCookies("JSESSIONID")
            .and()
            .sessionManagement()
            .sessionAuthenticationErrorUrl("/servicios/caducada");
}
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("campitos").password("celiesita").roles("USER");
    }
}