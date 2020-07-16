package com.wwn.film.user;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan(basePackages = {"com.wwn.film.user.dao"})
public class FilmUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmUserApplication.class, args);
    }

}
