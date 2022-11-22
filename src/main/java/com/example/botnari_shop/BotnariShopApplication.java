package com.example.botnari_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication( exclude = { SecurityAutoConfiguration.class } )
public class BotnariShopApplication {

    public static void main(String[] args) {

        SpringApplication.run(BotnariShopApplication.class, args);
    }

}
