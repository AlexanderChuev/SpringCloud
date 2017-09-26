package com.example.reservationservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "statistics-service")
public interface StatisticServiceClient {

    @RequestMapping(value = "/reader", method = RequestMethod.GET)
    String getReaderInfo();

    @RequestMapping(value = "/writer", method = RequestMethod.GET)
    String getWriterInfo();

}
