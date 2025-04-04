package com.exam.inmobiliario.productsmanagement.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.exam.inmobiliario.productsmanagement.api.model.FakeProduct;

@FeignClient(name = "FakeStoreClient", url = "${feign.url.fake-store}")
public interface FakeStoreProxy {

	@GetMapping("/products")
	public List<FakeProduct> getProducts();

	@GetMapping("/products/{id}")
	public FakeProduct getProduct(@PathVariable String id);
}
