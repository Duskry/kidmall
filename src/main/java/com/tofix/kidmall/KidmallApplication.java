package com.tofix.kidmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KidmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(KidmallApplication.class, args);
    }

}
