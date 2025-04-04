package com.exam.inmobiliario.productsmanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.inmobiliario.productsmanagement.api.model.FakeProduct;
import com.exam.inmobiliario.productsmanagement.proxies.FakeStoreProxy;
import com.exam.inmobiliario.productsmanagement.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<FakeProduct>> getProducts() {
		return new ResponseEntity<List<FakeProduct>>(productService.getProducts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FakeProduct> getProducts(@PathVariable String id) {
		return new ResponseEntity<FakeProduct>(productService.getProduct(id), HttpStatus.OK);
	}

}
