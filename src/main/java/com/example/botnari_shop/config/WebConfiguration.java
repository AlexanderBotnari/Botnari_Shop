package com.example.botnari_shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
//       registry.addViewController("/").setViewName("forward:/templates/home.html");
//       registry.addViewController("/produse").setViewName("forward:/html/produse.html");
//       registry.addViewController("/clienti").setViewName("forward:/html/clienti.html");
   }
   
}