package com.codingdojo.productsandcategories.repositories;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    Category findByIdIs(Long id);
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);
}