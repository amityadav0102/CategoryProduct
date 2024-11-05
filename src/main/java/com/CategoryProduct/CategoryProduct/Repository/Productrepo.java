package com.CategoryProduct.CategoryProduct.Repository;

import com.CategoryProduct.CategoryProduct.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepo extends JpaRepository<Product,Long> {
}
