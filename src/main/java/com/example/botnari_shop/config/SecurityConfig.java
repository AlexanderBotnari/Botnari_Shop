package com.example.botnari_shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	   public SecurityConfig() {
		      super();
		   }
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http = http
                .csrf()
                .disable();
         
        http
	        .formLogin()
	    	.loginPage("/login")
	    	.permitAll()
	    	.loginProcessingUrl("/login")
	    	.defaultSuccessUrl("/", true)
	        .and();
        
        http
	        .logout()
	        .logoutUrl("/logout")
	        .logoutSuccessUrl("/login")
	        .permitAll();
        
        http 
            .authorizeRequests()
            .antMatchers("/produse","/")
            .hasRole("ADMIN")
            .and();
        
        return http.build();
   }
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

}
