package com.pavan.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RatingsDataService1Application {

	public static void main(String[] args) {
		SpringApplication.run(RatingsDataService1Application.class, args);
	}

}
