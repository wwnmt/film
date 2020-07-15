package com.wwn.film.user;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class FilmUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmUserApplication.class, args);
    }

}
