package com.example.reservationservice.controller;

import com.example.reservationservice.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/foo")
public class MessageRestController {

    @Autowired
    ReservationService reservationService;

    @PreAuthorize("hasAuthority('FOO_READ')")
    @RequestMapping(value = "/reader", method = RequestMethod.GET)
    public String readFoo(HttpServletRequest request) {
        return reservationService.getReaderInfo();
    }


    @PreAuthorize("hasAuthority('FOO_WRITE')")
    @RequestMapping(value = "/writer", method = RequestMethod.GET)
    public String writeFoo() {
        return reservationService.getWriterInfo();
    }

}
