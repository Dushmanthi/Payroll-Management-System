package com.dushi.LoginServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
//@EnableDiscoveryClient
public class LoginServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServerApplication.class, args);
	}

}
