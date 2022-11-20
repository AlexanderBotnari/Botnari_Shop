package com.example.botnari_shop.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/clients/index/**","/products/index/**","/")
            .hasRole("ADMIN")
            .and()
            .formLogin()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true);
//        		
//        
//        return http.build();
//        http.authorizeRequests()
//        .antMatchers("/", "/index/**").permitAll()
//        .antMatchers("/index/**").hasAuthority("ADMIN")
//        .anyRequest().fullyAuthenticated()
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .failureUrl("/login?error")
//        .permitAll()
//        .and()
//        .logout()
//        .logoutUrl("/logout")
//        .logoutSuccessUrl("/index.html")
//        .permitAll()
//        .and()
//        .rememberMe();
        return http.build();
   }
    

    @Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("admin").password("admin").roles("ADMIN").build());
        return manager;

    }

}
