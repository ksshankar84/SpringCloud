package com.shan.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.test.context.junit.jupiter.EnabledIf;

@SpringBootApplication
//@EnableDiscoveryClient
public class CloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudClientApplication.class, args);
	}

}
