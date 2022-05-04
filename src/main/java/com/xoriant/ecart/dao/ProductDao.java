package com.xoriant.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.model.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	Product findByProductName(String productName);

	List<Product> findByBrand(String brandName);

	@Query(value="select p.productId,p.productName,p.price,p.description,b.brand_id,b.brand_name from products p inner join brands b on p.brand_brand_id=b.brand_id",nativeQuery = true)
	List<Product> fetchAll();

	List<Product> findByPriceIsBetween(double minPrice, double maxPrice);

	List<Product> findByPriceLessThan(double minPrice);

	List<Product> findByPriceGreaterThanEqual(double maxPrice);

}
