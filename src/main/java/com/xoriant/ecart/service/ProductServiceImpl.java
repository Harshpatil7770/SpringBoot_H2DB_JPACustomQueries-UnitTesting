package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public Product addNewProduct(Product product) {

		return productDao.save(product);
	}

	@Override
	public List<Product> addNewListOfProduct(List<Product> prodLists) {

		return productDao.saveAll(prodLists);
	}

	@Override
	public Product findByProductName(String productName) {

		return productDao.findByProductName(productName);
	}

	@Override
	public List<Product> findByBrandName(String brandName) {

		return productDao.findByBrand(brandName);
	}

	@Override
	public List<Product> findAll() {

		return productDao.fetchAll();
	}

	@Override
	public Optional<Product> findByProductId(int productId) {

		return productDao.findById(productId);
	}

	@Override
	public List<Product> findProductBetweenPrice(double minPrice, double maxPrice) {

		return productDao.findByPriceIsBetween(minPrice, maxPrice);
	}

	@Override
	public List<Product> findByLessThanPrice(double minPrice) {

		return productDao.findByPriceLessThan(minPrice);
	}

	@Override
	public List<Product> findByGreaterThanPrice(double maxPrice) {

		return productDao.findByPriceGreaterThanEqual(maxPrice);
	}

}
