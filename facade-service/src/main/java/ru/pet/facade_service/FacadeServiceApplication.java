package ru.pet.facade_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "ru.pet.facade_service.application.feign")
@SpringBootApplication
public class FacadeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacadeServiceApplication.class, args);
	}

}
