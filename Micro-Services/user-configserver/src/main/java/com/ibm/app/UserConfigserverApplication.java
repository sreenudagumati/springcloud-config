package com.ibm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class UserConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserConfigserverApplication.class, args);
	}
}
