package com.backend.app.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class SpringbootServiceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceStoreApplication.class, args);
	}

}
