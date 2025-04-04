package com.exam.inmobiliario.ordersmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrdersManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersManagementApplication.class, args);
	}

}
