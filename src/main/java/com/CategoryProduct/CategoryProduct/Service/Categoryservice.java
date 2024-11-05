package com.CategoryProduct.CategoryProduct.Service;

import com.CategoryProduct.CategoryProduct.DTO.CategoryDTO1;
import com.CategoryProduct.CategoryProduct.Entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Categoryservice {
    public Page<Category> getAllCategories(Pageable pageable);

   public CategoryDTO1 getByid(Long id);

  public  Category createCategory(Category category);

  public CategoryDTO1 updateCategory(long id, Category category);

    public void deleteCategory(Long id);
}
