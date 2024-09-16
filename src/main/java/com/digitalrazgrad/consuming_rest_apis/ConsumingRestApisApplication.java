package com.digitalrazgrad.consuming_rest_apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class ConsumingRestApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApisApplication.class, args);
	}

}
