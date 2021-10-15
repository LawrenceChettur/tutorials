package com.law.springdata.tutorials.productdata.repos;

import com.law.springdata.tutorials.productdata.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> readByNameAndPrice(String name, double price);

    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByDescriptionContains(String regEx);

    List<Product> findByPriceBetween(double fromPrice, double toPrice);

    List<Product> findByDescriptionLike(String regEx);

    List<Product> findByIdIn(List<Integer> ids);
}
