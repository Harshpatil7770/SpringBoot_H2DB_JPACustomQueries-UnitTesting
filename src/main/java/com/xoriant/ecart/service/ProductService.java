package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import com.xoriant.ecart.model.Product;

public interface ProductService {

	Product addNewProduct(Product product);

	List<Product> addNewListOfProduct(List<Product> prodLists);

	Product findByProductName(String productName);
	
	List<Product> findByBrandName(String brandName);
	
	//inner join use
	List<Product> findAll();
	
	Optional<Product> findByProductId(int productId);
	
	List<Product> findProductBetweenPrice(double minPrice,double maxPrice);
	
	List<Product> findByLessThanPrice(double minPrice);
	
	List<Product> findByGreaterThanPrice(double maxPrice);
 }
