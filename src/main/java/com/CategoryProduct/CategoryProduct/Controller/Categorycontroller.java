package com.CategoryProduct.CategoryProduct.Controller;

import com.CategoryProduct.CategoryProduct.DTO.CategoryDTO1;
import com.CategoryProduct.CategoryProduct.Entity.Category;
import com.CategoryProduct.CategoryProduct.Service.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorys")

public class Categorycontroller {
    @Autowired
    Categoryservice categoryservice;

    @GetMapping
    public Page<Category> getallCategory(Pageable pageable) {
        return categoryservice.getAllCategories(pageable);
    }

    @GetMapping("/{id}")
    public CategoryDTO1 getByid(@PathVariable Long id) {
        return categoryservice.getByid(id);
    }

    @PostMapping
    public Category creteCategory(@RequestBody Category category) {
        return categoryservice.createCategory(category);
    }

    @PutMapping("/{id}")
    public CategoryDTO1 updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryservice.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deletebyid(@PathVariable Long id) {
        categoryservice.deleteCategory(id);
    }


}
