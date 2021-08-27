package com.solidsystems.siss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SissApplication {

    public static void main(String[] args) {
        SpringApplication.run(SissApplication.class, args);
    }

}
