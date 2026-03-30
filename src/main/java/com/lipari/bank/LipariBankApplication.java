package com.lipari.bank;

import com.lipari.bank.shared.config.LipariBankProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lipari.bank", "com.liparibank.lifecycle"})
@EnableConfigurationProperties(LipariBankProperties.class)
public class LipariBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(LipariBankApplication.class, args);
    }
}
