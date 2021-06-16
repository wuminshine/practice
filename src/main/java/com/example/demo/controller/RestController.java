package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping(value = "/hello")
    public String hello()
    {
//        return "hello";
        throw new NullPointerException();
    }
}
