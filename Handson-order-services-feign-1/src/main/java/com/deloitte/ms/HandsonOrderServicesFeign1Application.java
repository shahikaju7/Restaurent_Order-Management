package com.deloitte.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HandsonOrderServicesFeign1Application {

	public static void main(String[] args) {
		SpringApplication.run(HandsonOrderServicesFeign1Application.class, args);
	}

}
