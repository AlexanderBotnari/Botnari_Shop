package com.example.botnari_shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.botnari_shop.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Autowired
	UserService userService;
	
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
            .antMatchers("/js/**","/html/**","/","/produse","/clienti","/succes_add_product","/utilizatori")
            .hasAuthority("ADMIN")
            .and();
        
        http 
        	.authorizeRequests()
        	.antMatchers("/js/**","/html/**","/","/produse","/clienti","/succes_add_product")
        	.hasAnyAuthority("USER","ADMIN")
        	.and();
        
        
        return http.build();
   }
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userService).passwordEncoder(encoder());
    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
