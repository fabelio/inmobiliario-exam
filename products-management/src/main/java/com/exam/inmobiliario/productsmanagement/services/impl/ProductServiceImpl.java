package com.exam.inmobiliario.productsmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.inmobiliario.productsmanagement.api.model.FakeProduct;
import com.exam.inmobiliario.productsmanagement.proxies.FakeStoreProxy;
import com.exam.inmobiliario.productsmanagement.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private FakeStoreProxy fakeStoreProxy;

	@Override
	public List<FakeProduct> getProducts() {
		return fakeStoreProxy.getProducts();
	}

	@Override
	public FakeProduct getProduct(String id) {
		return fakeStoreProxy.getProduct(id);
	}

}
