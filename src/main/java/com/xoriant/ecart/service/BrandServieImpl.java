package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.BrandDao;
import com.xoriant.ecart.model.Brand;

@Service
public class BrandServieImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public Brand addNewBrand(Brand brand) {

		return brandDao.save(brand);
	}

	@Override
	public List<Brand> addListOfBrand(List<Brand> BrandLists) {

		return brandDao.saveAll(BrandLists);
	}

	@Override
	public Brand findByName(String BrandName) {

		return brandDao.findByBrandName(BrandName);
	}

	@Override
	public Optional<Brand> findById(int BrandId) {
		Optional<Brand> existBrand = brandDao.findById(BrandId);
		return existBrand;
	}

	@Override
	public List<Brand> findAll() {

		return brandDao.findAll();
	}

	@Override
	public void deleteByBrandId(int BrandId) {

		brandDao.deleteById(BrandId);
	}

}
