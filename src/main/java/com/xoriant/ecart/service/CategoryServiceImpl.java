package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.CategoryDao;
import com.xoriant.ecart.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category addNewCategory(Category category) {
		return categoryDao.save(category);

	}

	@Override
	public List<Category> addListOfCategory(List<Category> catLists) {

		return categoryDao.saveAll(catLists);
	}

	@Override
	public Category findByName(String categoryName) {

		return categoryDao.findByCategoryName(categoryName);
	}

	@Override
	public Optional<Category> findById(int CategoryId) {

		Optional<Category> existCat = categoryDao.findById(CategoryId);
		if (existCat.isPresent()) {
			return categoryDao.findById(CategoryId);
		}
		return null;
	}

	@Override
	public List<Category> findAll() {

		return categoryDao.findAll();
	}

	@Override
	public void deleteByCategoryId(int categoryId) {
		categoryDao.deleteById(categoryId);

	}

}
