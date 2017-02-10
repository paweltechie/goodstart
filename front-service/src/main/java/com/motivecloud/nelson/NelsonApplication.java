package com.motivecloud.nelson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NelsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(NelsonApplication.class, args);
	}
}
