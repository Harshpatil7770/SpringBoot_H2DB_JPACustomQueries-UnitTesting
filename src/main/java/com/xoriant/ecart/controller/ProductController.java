package com.xoriant.ecart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.model.Product;
import com.xoriant.ecart.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	Product addNewProduct(@RequestBody Product product) {
		return productService.addNewProduct(product);
	}

	@PostMapping("/saveAll")
	List<Product> addNewListOfProduct(@RequestBody List<Product> prodLists) {
		return productService.addNewListOfProduct(prodLists);
	}

	@GetMapping("/find/{productName}")
	Product findByProductName(@PathVariable String productName) {
		return productService.findByProductName(productName);
	}

	@GetMapping("findAll/{brandName}")
	List<Product> findByBrandName(@PathVariable String brandName) {
		return productService.findByBrandName(brandName);
	}

	// inner join use
	@GetMapping("/findAll")
	List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/find/product/{productId}")
	public Optional<Product> findByProductId(@PathVariable int productId) {
		return productService.findByProductId(productId);
	}

	@GetMapping("/find/{minPrice}/{maxPrice}")
	List<Product> findProductBetweenPrice(@PathVariable double minPrice, @PathVariable double maxPrice) {
		return productService.findProductBetweenPrice(minPrice, maxPrice);
	}

	@GetMapping("/find/minPrice/{minPrice}")
	List<Product> findByLessThanPrice(@PathVariable double minPrice) {
		return productService.findByLessThanPrice(minPrice);
	}

	@GetMapping("/find/product/maxPrice/{maxPrice}")
	List<Product> findByGreaterThanPrice(@PathVariable double maxPrice) {
		return productService.findByGreaterThanPrice(maxPrice);
	}
}