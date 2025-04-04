package com.exam.inmobiliario.ordersmanagement.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.inmobiliario.ordersmanagement.model.Order;
import com.exam.inmobiliario.ordersmanagement.repositories.OrderRepository;

public interface OrderRepositoryJpa  extends OrderRepository, JpaRepository<Order, Integer> {
	
}
