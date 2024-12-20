package com.TM.carmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.TM")
public class CarmanagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarmanagementApplication.class, args);
    }
}
