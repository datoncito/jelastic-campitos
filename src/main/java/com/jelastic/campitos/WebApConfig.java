/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jelastic.campitos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author campitos
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.jelastic.campitos")
public class WebApConfig extends WebMvcConfigurerAdapter {
  @Bean
    public ViewResolver getViewResolver(){
         System.out.println("===========>>> DispatcherContext CONFIGURANDO LAS VISTAS PARA LA WEB MVC!!!:");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    /*
    La siguiente se ocupa si ocupas el multipart de commons y no el de servlet 3.0, ese es
    otra configuracion de tu dispatcherservlet, aucerdateque este es el dispátcher servlet.
    */
   
    @Bean
    public CommonsMultipartResolver multipartResolver() {       
        System.out.println("===========>>> DispatcherContext CONFIGURANDO multipartResolver (ESTE ES PARA CONFIGURAR CON APACHE MULTIPART:");
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(7000000);
        return multipartResolver;
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
         System.out.println("===========>>> DispatcherContext configurando los recursos, (AUNQUE CASI NO LOS USO):");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }  
}
