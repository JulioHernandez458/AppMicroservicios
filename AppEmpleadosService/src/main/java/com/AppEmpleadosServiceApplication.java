package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableEurekaClient
public class AppEmpleadosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEmpleadosServiceApplication.class, args);
	}

}
