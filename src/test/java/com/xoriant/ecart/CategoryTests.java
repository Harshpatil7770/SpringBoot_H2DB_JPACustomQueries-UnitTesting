package com.xoriant.ecart;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.xoriant.ecart.dao.CategoryDao;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.service.CategoryServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CategoryTests {

	@Mock
	CategoryDao categoryDao;

	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;

	private static Category category1;
	private static Category category2;

	@BeforeAll
	public static void beforeAll() {
		category1 = new Category(101, "Laptops");
		category2 = new Category(102, "SmartPhones");
	}

	@Test
	public void addNewCategory() {

		when(categoryDao.save(category1)).thenReturn(category1);
		assertEquals(category1, categoryServiceImpl.addNewCategory(category1));
	}

	@Test
	public void addListOfCategory() {
		List<Category> catLists = new ArrayList<Category>();
		catLists.add(category1);
		catLists.add(category2);
		when(categoryDao.saveAll(catLists)).thenReturn(catLists);
		assertEquals(catLists, categoryServiceImpl.addListOfCategory(catLists));

	}

	@Test
	public void findByName() {

		when(categoryDao.findByCategoryName(category1.getCategoryName())).thenReturn(category1);
		assertEquals(category1, categoryServiceImpl.findByName(category1.getCategoryName()));

	}

	@Test
	public void findById() {

		Optional<Category> existCat = Optional.of(category1);
		when(categoryDao.findById(category1.getCategoryId())).thenReturn(existCat);
		assertEquals(existCat, categoryServiceImpl.findById(category1.getCategoryId()));
	}

	@Test
	public void findAll() {

		List<Category> catLists = new ArrayList<Category>();
		catLists.add(category1);
		catLists.add(category2);
		when(categoryDao.findAll()).thenReturn(catLists);
		assertEquals(2, categoryServiceImpl.findAll().size());
	}

	@Test
	public void deleteByCategoryId() {
		categoryDao.deleteById(category1.getCategoryId());
		assertThat(categoryDao.existsById(category1.getCategoryId())).isFalse();
	}

}
