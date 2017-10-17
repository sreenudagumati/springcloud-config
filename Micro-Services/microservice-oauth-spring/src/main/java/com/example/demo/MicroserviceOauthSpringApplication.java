package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.controller.PersonController;

@SpringBootApplication
@ComponentScan(basePackageClasses=PersonController.class)
@EnableJpaRepositories
public class MicroserviceOauthSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOauthSpringApplication.class, args);
	}
}
