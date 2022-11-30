package com.example.botnari_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication( exclude = { SecurityAutoConfiguration.class } )
public class BotnariShopApplication {

    public static void main(String[] args) {

        SpringApplication.run(BotnariShopApplication.class, args);
    }

}
