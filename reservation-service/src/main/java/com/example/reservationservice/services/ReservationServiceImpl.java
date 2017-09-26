package com.example.reservationservice.services;

import com.example.reservationservice.client.StatisticServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    StatisticServiceClient statisticServiceClient;

    @HystrixCommand(fallbackMethod = "readerInfo")
    @Override
    public String getReaderInfo(){
        return statisticServiceClient.getReaderInfo();
    }

    @HystrixCommand(fallbackMethod = "writerInfo")
    @Override
    public String getWriterInfo(){
        return statisticServiceClient.getWriterInfo();
    }

    public String readerInfo() {
        return "Hystrix method for reader work";
    }

    public String writerInfo() {
        return "Hystrix method for writer work";
    }
}
