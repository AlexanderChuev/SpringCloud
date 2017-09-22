package com.example.reservationservice.services;

import com.example.reservationservice.client.StatisticServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    StatisticServiceClient statisticServiceClient;

    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public String getInfo(){
        return statisticServiceClient.getInfo();
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }
}
