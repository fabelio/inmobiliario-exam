package com.exam.inmobiliario.ordersmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.inmobiliario.ordersmanagement.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
	OrderStatus findByCode(String code);
}
