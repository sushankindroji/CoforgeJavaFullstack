package com.coforge.training.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HelloworldServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldServiceApplication.class, args);
	}

}
