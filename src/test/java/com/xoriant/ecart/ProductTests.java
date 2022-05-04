package com.xoriant.ecart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.model.Brand;
import com.xoriant.ecart.model.Product;
import com.xoriant.ecart.service.ProductServiceImpl;

@SpringBootTest
public class ProductTests {

	@Mock
	ProductDao productDao;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	private static Brand b1;
	private static Brand b2;
	private static Product prod1;
	private static Product prod2;

	@BeforeAll
	public static void beforeAll() {
		b1 = new Brand();
		b1.setBrandId(101);
		b1.setBrandName("Samsung");
		b2 = new Brand();
		b1.setBrandId(102);
		b1.setBrandName("Oppo");
		prod1 = new Product(101, "Samsung Galaxy Core", 12500, "Galaxy Series", b1);
		prod2 = new Product(102, "Oppo f1f", 15999, "Selfi Expert", b2);
	}

	@Test
	public void addNewProduct() {

		when(productDao.save(prod1)).thenReturn(prod1);
		assertEquals(prod1, productServiceImpl.addNewProduct(prod1));
	}

	@Test
	public void addNewListOfProduct() {
		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(prod1);
		prodLists.add(prod2);
		when(productDao.saveAll(prodLists)).thenReturn(prodLists);
		assertEquals(prodLists, productServiceImpl.addNewListOfProduct(prodLists));
	}

	@Test
	public void findByProductName() {
		when(productDao.findByProductName(prod1.getProductName())).thenReturn(prod1);
		assertEquals(prod1, productServiceImpl.findByProductName(prod1.getProductName()));
	}

	@Test
	public void findByBrandName() {

		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(prod1);
		prodLists.add(prod2);
		String brandName = "Samsung";
		when(productDao.findByBrand(brandName)).thenReturn(prodLists);
		assertEquals(prodLists, productServiceImpl.findByBrandName(brandName));
	}

//	//inner join use
	@Test
	public void findAll() {
		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(prod1);
		prodLists.add(prod2);
		when(productDao.findAll()).thenReturn(prodLists);
		assertEquals(prodLists, productServiceImpl.findAll());
	}

	@Test
	public void findByProductId() {

		Optional<Product> existProd = Optional.of(prod1);
		when(productDao.findById(prod1.getProductId())).thenReturn(existProd);
		assertEquals(existProd, productServiceImpl.findByProductId(prod1.getProductId()));
	}

	@Test
	public void findProductBetweenPrice() {
		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(prod1);
		prodLists.add(prod2);
		double minPrice = 10000;
		double maxPrice = 10000;
		when(productDao.findByPriceIsBetween(minPrice, maxPrice)).thenReturn(prodLists);
		assertEquals(prodLists, productServiceImpl.findProductBetweenPrice(minPrice, maxPrice));
	}

	@Test
	public void findByLessThanPrice() {
		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(prod1);
		prodLists.add(prod2);
		double minPrice = 10000;
		when(productDao.findByPriceLessThan(minPrice)).thenReturn(prodLists);
		assertEquals(prodLists, productServiceImpl.findByLessThanPrice(minPrice));
	}

	@Test
	public void findByGreaterThanPrice() {
		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(prod1);
		prodLists.add(prod2);
		double maxPrice = 30000;
		when(productDao.findByPriceGreaterThanEqual(maxPrice)).thenReturn(prodLists);
		assertEquals(prodLists, productServiceImpl.findByGreaterThanPrice(maxPrice));
	}
}
