package com.example.bookmanageback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.bookmanageback.mapper")
public class BookmanagebackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmanagebackApplication.class, args);
    }

}
