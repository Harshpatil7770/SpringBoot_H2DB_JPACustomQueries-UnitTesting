package com.xoriant.ecart;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.xoriant.ecart.dao.BrandDao;
import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.service.BrandServieImpl;
import com.xoriant.ecart.service.CategoryServiceImpl;

@SpringBootTest
public class BrandTests {

	@Mock
	BrandDao brandDao;

	@InjectMocks
	BrandServieImpl brandServieImpl;

	private static Brand brand1;
	private static Brand brand2;

	@BeforeAll
	public static void beforeAll() {
		brand1 = new Brand(101, "Samsung", null);
		brand2 = new Brand(102, "Oppo", null);
	}

	@Test
	public void addNewBrand() {

		when(brandDao.save(brand1)).thenReturn(brand1);
		assertEquals(brand1, brandServieImpl.addNewBrand(brand1));
	}

	@Test
	public void addListOfBrand() {
		List<Brand> brandLists = new ArrayList<Brand>();
		brandLists.add(brand1);
		brandLists.add(brand2);
		when(brandDao.saveAll(brandLists)).thenReturn(brandLists);
		assertEquals(brandLists, brandServieImpl.addListOfBrand(brandLists));
	}

	@Test
	public void findByName() {
		when(brandDao.findByBrandName(brand1.getBrandName())).thenReturn(brand1);
		assertEquals(brand1, brandServieImpl.findByName(brand1.getBrandName()));
	}

	@Test
	public void findById() {
		Optional<Brand> existBrand = Optional.of(brand1);
		when(brandDao.findById(brand1.getBrandId())).thenReturn(existBrand);
		assertEquals(existBrand, brandServieImpl.findById(brand1.getBrandId()));
	}

	@Test
	public void findAll() {
		List<Brand> brandLists = new ArrayList<Brand>();
		brandLists.add(brand1);
		brandLists.add(brand2);
		when(brandDao.findAll()).thenReturn(brandLists);
		assertEquals(brandLists, brandServieImpl.findAll());
	}

	@Test
	public void deleteByBrandId() {
		brandDao.deleteById(brand1.getBrandId());
		assertThat(brandDao.existsById(brand1.getBrandId())).isFalse();
	}
}
