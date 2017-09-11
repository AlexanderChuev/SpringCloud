package com.example.reservationclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
