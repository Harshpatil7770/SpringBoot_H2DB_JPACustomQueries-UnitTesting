package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import com.xoriant.ecart.model.Brand;

public interface BrandService {

	Brand addNewBrand(Brand brand);

	List<Brand> addListOfBrand(List<Brand> BrandLists);
	
	Brand findByName(String BrandName);
	
	Optional<Brand> findById(int BrandId);
	
	List<Brand> findAll();
	
	void deleteByBrandId(int BrandId);
}
