package com.example.staffhouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test1 {

    @RequestMapping("/test")
    public String getTest() throws Exception {
        return "Hello World";
    }
}
