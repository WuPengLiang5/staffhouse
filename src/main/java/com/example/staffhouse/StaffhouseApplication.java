package com.example.staffhouse;

import com.example.staffhouse.websocket.FrameSpringBeanUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.staffhouse.dao")
@EnableScheduling
public class StaffhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffhouseApplication.class, args);
    }

    @Bean
    public FrameSpringBeanUtil frameSpringBeanUtil(){
        return new FrameSpringBeanUtil();
    }
}
