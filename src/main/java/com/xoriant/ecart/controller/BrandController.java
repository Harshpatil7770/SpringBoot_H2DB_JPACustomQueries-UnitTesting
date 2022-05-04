package com.xoriant.ecart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.service.BrandService;

@RequestMapping("/api/brand")
@RestController
public class BrandController {

	@Autowired
	private BrandService brandService;

	@PostMapping("/save")
	Brand addNewBrand(@RequestBody Brand brand) {
		return brandService.addNewBrand(brand);
	}

	@PostMapping("/saveAll")
	List<Brand> addListOfBrand(@RequestBody List<Brand> BrandLists) {
		return brandService.addListOfBrand(BrandLists);
	}

	@GetMapping("/find/{brandName}")
	Brand findByName(@PathVariable String brandName) {
		return brandService.findByName(brandName);
	}

	@GetMapping("/find/brand/{BrandId}")
	Optional<Brand> findById(@PathVariable int BrandId) {
		return brandService.findById(BrandId);
	}

	@GetMapping("/findAll")
	List<Brand> findAll() {
		return brandService.findAll();
	}

	@DeleteMapping("/delete/{BrandId}")
	void deleteByBrandId(int BrandId) {
		brandService.deleteByBrandId(BrandId);
	}
}
