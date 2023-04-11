package com.homeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HomeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeServiceApplication.class, args);
	}

}
