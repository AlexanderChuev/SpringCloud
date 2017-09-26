package com.example.statisticalservice.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController (value = "/statistics-service")
public class SomeController {

   // @PreAuthorize("hasRole('FOO_READ')")
    @RequestMapping(value = "/reader", method = RequestMethod.GET)
    public String getReaderInfo(){
        return "Statistics-service method for reader";
    }

    @RequestMapping(value = "/writer", method = RequestMethod.GET)
    public String hello(){
        System.out.println("I");
        return "Statistics-service method for writer";
    }

}
