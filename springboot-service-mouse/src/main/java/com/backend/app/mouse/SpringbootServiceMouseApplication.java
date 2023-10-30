package com.backend.app.mouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceMouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceMouseApplication.class, args);
	}

}
