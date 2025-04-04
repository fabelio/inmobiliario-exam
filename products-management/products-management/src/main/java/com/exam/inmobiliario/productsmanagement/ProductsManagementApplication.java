package com.exam.inmobiliario.productsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProductsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsManagementApplication.class, args);
	}

}
