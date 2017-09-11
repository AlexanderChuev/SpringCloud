package com.example.reservationclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "reservations")
public class ReservationApiGatewayRestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/names")
    public Collection<String> getReservationNames() {

        ParameterizedTypeReference<Resources<Reservation>> ptr = new ParameterizedTypeReference<Resources<Reservation>>() {};

        ResponseEntity<Resources<Reservation>> responseEntity = this.restTemplate.exchange("http://reservation-service/reservations", HttpMethod.GET, null, ptr);
        return  responseEntity
                .getBody()
                .getContent()
                .stream()
                .map(Reservation::getReservationName)
                .collect(Collectors.toList());
    }
}
