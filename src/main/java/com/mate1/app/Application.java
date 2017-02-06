package com.mate1.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mate1.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}