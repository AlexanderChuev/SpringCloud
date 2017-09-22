package com.example.statisticalservice.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController (value = "/statistics-service")
public class SomeController {

    
    @RequestMapping(value = "/stat", method = RequestMethod.GET)
    public String getInfo(){
        System.out.println("Hi");
        return UUID.randomUUID().toString();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void hello(){
        System.out.println("Hello service");
    }

}
