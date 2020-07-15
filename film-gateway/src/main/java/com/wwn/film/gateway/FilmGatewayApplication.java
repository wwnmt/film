package com.wwn.film.gateway;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDubboConfiguration
public class FilmGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmGatewayApplication.class, args);
    }

}
