package com.exam.inmobiliario.ordersmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.inmobiliario.ordersmanagement.dto.OrderDto;
import com.exam.inmobiliario.ordersmanagement.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDto>> listOrders(@RequestParam(required = false, defaultValue = "0") int pageNumber,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		return new ResponseEntity<List<OrderDto>>(this.orderService.listOrders(pageNumber, pageSize), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> getOrder(@PathVariable String id) {
		return new ResponseEntity<OrderDto>(this.orderService.getOrder(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<OrderDto> createOrder(@RequestBody(required = true) OrderDto order) {
		return new ResponseEntity<OrderDto>(this.orderService.createOrder(order), HttpStatus.OK);
	}

	@PostMapping("/{id}/pay")
	public ResponseEntity<OrderDto> payOrder(@PathVariable String id) {
		return new ResponseEntity<OrderDto>(this.orderService.payOrder(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
		this.orderService.deleteOrder(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderDto> updateOrder(@PathVariable String id, @RequestBody(required = true) OrderDto order) {
		return new ResponseEntity<OrderDto>(this.orderService.updateOrder(id, order), HttpStatus.OK);
	}

}
