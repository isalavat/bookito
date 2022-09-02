package com.bookito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BookitoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookitoServiceApplication.class, args);
	}

}
