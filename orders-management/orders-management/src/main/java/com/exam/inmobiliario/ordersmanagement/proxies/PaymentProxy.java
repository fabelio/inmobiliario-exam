package com.exam.inmobiliario.ordersmanagement.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exam.inmobiliario.ordersmanagement.dto.PaymentDto;

@FeignClient(name = "PaymentClient", url = "${feign.url.payments}")
public interface PaymentProxy {

	@PostMapping("/payment/order/{id}")
	public ResponseEntity<PaymentDto> payOrder(@RequestBody(required = true) PaymentDto payment,
			@PathVariable String id);
}
