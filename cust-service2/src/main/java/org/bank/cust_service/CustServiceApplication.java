package org.bank.cust_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustServiceApplication.class, args);
	}

}
