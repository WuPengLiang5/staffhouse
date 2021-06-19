package com.example.staffhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.staffhouse.dao")
public class StaffhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffhouseApplication.class, args);
    }

}
