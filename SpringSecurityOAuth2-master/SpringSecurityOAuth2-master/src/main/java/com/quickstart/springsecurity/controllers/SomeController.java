package com.quickstart.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping("/")
    public String home(){
        return "hello";
    }

    @GetMapping("/private")
    public String privateArea(){
        return "private";
    }
}
