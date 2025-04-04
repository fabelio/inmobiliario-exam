package com.exam.inmobiliario.ordersmanagement.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.inmobiliario.ordersmanagement.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query(value = "select sum(price*quantity) from order_details od where od.order_id = ?", nativeQuery = true)
	BigDecimal getTotalOrder(Integer id);
}
