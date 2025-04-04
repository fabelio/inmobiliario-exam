package com.exam.inmobiliario.ordersmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.inmobiliario.ordersmanagement.dto.OrderDetailDto;
import com.exam.inmobiliario.ordersmanagement.service.OrderDetailService;

@RestController
@RequestMapping("/order-details")
@CrossOrigin
public class OrderDetailController {

	@Autowired
	OrderDetailService service;

	@GetMapping("/{id}")
	public ResponseEntity<OrderDetailDto> getOrderDetail(@PathVariable String id) {
		return new ResponseEntity<OrderDetailDto>(this.service.getOrderDeail(id), HttpStatus.OK);
	}

	@PostMapping("/order/{id}")
	public ResponseEntity<OrderDetailDto> createOrderDetail(@RequestBody(required = true) OrderDetailDto orderDetail,
			@PathVariable String id) {
		return new ResponseEntity<OrderDetailDto>(this.service.createOrderDetail(orderDetail, id), HttpStatus.OK);
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<List<OrderDetailDto>> getOrderDetailListByOrderId(@PathVariable(name = "id") String orderId) {
		return new ResponseEntity<List<OrderDetailDto>>(this.service.getOrderDetailListByOrderId(orderId),
				HttpStatus.OK);
	}

	@PostMapping("/order/{id}/list")
	public ResponseEntity<List<OrderDetailDto>> createOrderDetailList(
			@RequestBody(required = true) List<OrderDetailDto> orderDetail, @PathVariable String id) {
		return new ResponseEntity<List<OrderDetailDto>>(this.service.createOrderDetailList(orderDetail, id),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrderDetail(@PathVariable String id) {
		this.service.deleteOrderDetail(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderDetailDto> updateOrderDetail(@PathVariable String id,
			@RequestBody(required = true) OrderDetailDto orderDetail) {
		return new ResponseEntity<OrderDetailDto>(this.service.updateOrderDetail(id, orderDetail), HttpStatus.OK);
	}
}
