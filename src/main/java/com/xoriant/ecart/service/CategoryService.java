package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import com.xoriant.ecart.model.Category;

public interface CategoryService {

	Category addNewCategory(Category category);

	List<Category> addListOfCategory(List<Category> catLists);
	
	Category findByName(String categoryName);
	
	Optional<Category> findById(int CategoryId);
	
	List<Category> findAll();
	
	void deleteByCategoryId(int categoryId);
 
}