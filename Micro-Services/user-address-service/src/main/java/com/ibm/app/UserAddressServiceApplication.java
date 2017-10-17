package com.ibm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
@EnableAutoConfiguration
public class UserAddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAddressServiceApplication.class, args);
	}
	
	@Bean
	public Docket newsApi() {
				
		return new Docket(DocumentationType.SWAGGER_2).groupName("user-address-service").apiInfo(apiInfo()).select().paths(PathSelectors.regex("/userAddress.*")).build();
				
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("User Address Microservice","User Address","1.0","http://in.ibm.com","Admin","GPL","");
	}
}
