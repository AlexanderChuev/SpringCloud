package com.example.reservationservice.controller;

import com.example.reservationservice.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/foo")
public class MessageRestController {

    @Autowired
    ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET)
    public String readFoo() {
        return reservationService.getInfo();
    }


    @PreAuthorize("hasAuthority('FOO_WRITE')")
    @RequestMapping(method = RequestMethod.POST)
    public String writeFoo() {
        return "write foo " + UUID.randomUUID().toString();
    }

}
