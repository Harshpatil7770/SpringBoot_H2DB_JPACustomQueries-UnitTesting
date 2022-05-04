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

import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/save")
	public Category addNewCategory(@RequestBody Category category) {
		return categoryService.addNewCategory(category);
	}

	@PostMapping("/saveAll")
	public List<Category> saveCategoryAll(@RequestBody List<Category> catLists) {
		return categoryService.addListOfCategory(catLists);
	}

	@GetMapping("/find/{categoryName}")
	public Category findByCategoryName(@PathVariable String categoryName) {
		return categoryService.findByName(categoryName);
	}

	@GetMapping("/find/category/{categoryId}")
	Optional<Category> findByCategoryId(@PathVariable int categoryId) {
		return categoryService.findById(categoryId);
	}

	@GetMapping("/findAll")
	public List<Category> findAll() {
		return categoryService.findAll();
	}

	@DeleteMapping("/delete/{categoryId}")
	public void deleteByCategoryId(@PathVariable int categoryId) {
		categoryService.deleteByCategoryId(categoryId);
	}
}
