package com.law.springdata.tutorials.productdata;

import com.law.springdata.tutorials.productdata.entities.Product;
import com.law.springdata.tutorials.productdata.repos.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Product product = new Product();
		product.setId(1);
		product.setName("Pixel");
		product.setDescription("Android is cool");
		product.setPrice(9000d);

		productRepository.save(product);
	}

	@Test
	public void testRead() {
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		assertEquals("Pixel", product.getName());
	}

	@Test
	public void testUpdate(){
		Product product = productRepository.findById(1).get();
		product.setPrice(1200d);
		productRepository.save(product);
	}

	@Test
	public void testDelete(){
		if(productRepository.existsById(1)) {
			productRepository.deleteById(1);
		}
	}

	@Test
	public void testCount(){
		System.out.println("Total Records:==========>" + productRepository.count());
	}

	@Test
	public void testFindByName() {
		List<Product> products = productRepository.findByName("Pixel");
		products.forEach( p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testReadByNameAndPrice() {
		List<Product> products = productRepository.readByNameAndPrice("Pixel", 9000d);
		products.forEach( p -> System.out.println(p.getDescription()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = productRepository.findByPriceGreaterThan(4000d);
		products.forEach( p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescriptionContains() {
		List<Product> products = productRepository.findByDescriptionContains("Android");
		products.forEach( p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<Product> products = productRepository.findByPriceBetween(1000d, 10000d);
		products.forEach( p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescriptionLike() {
		List<Product> products = productRepository.findByDescriptionLike("cool");
		products.forEach( p -> System.out.println(p.getName()));
	}

    @Test
    public void testFindByIdIn() {
        List<Product> products = productRepository.findByIdIn(Arrays.asList(1, 2, 3));
        products.forEach( p -> System.out.println(p.getName()));
    }

}
