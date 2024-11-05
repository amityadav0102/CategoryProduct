package com.CategoryProduct.CategoryProduct.Repository;

import com.CategoryProduct.CategoryProduct.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoryrepo extends JpaRepository<Category, Long> {

}
