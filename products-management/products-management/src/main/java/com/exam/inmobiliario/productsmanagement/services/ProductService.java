package com.exam.inmobiliario.productsmanagement.services;

import java.util.List;

import com.exam.inmobiliario.productsmanagement.api.model.FakeProduct;

public interface ProductService {

	List<FakeProduct> getProducts();

	FakeProduct getProduct(String id);
}
