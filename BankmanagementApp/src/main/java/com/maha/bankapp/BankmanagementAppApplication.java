package com.maha.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2

public class BankmanagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankmanagementAppApplication.class, args);
    }

}
