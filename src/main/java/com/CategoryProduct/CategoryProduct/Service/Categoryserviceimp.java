package com.CategoryProduct.CategoryProduct.Service;

import com.CategoryProduct.CategoryProduct.DTO.CategoryDTO1;
import com.CategoryProduct.CategoryProduct.DTO.ProductDTO1;
import com.CategoryProduct.CategoryProduct.Entity.Category;
import com.CategoryProduct.CategoryProduct.Entity.Product;
import com.CategoryProduct.CategoryProduct.Repository.Categoryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Categoryserviceimp implements Categoryservice {
    @Autowired
    Categoryrepo categoryrepo;

    public Page<Category> getAllCategories(Pageable pageable) {

        return categoryrepo.findAll(pageable);
    }

    @Override
    public CategoryDTO1 getByid(Long id) {

        Category category = categoryrepo.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
        List<ProductDTO1> productDTO1 = new ArrayList<>();
        for (Product products : category.getProducts()) {
            productDTO1.add(new ProductDTO1(products.getId(), products.getName()));
        }
        return new CategoryDTO1(category.getId(), category.getName(), productDTO1);

    }

    @Override
    public Category createCategory(Category category) {
        return categoryrepo.save(category);
    }

    @Override
    public CategoryDTO1 updateCategory(long id, Category categorydetails) {

        Category category = categoryrepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));

        category.setName(categorydetails.getName());
        categoryrepo.save(category);
        List<ProductDTO1> productDTO1s = new ArrayList<>();

        for (Product product : category.getProducts()) {
            productDTO1s.add(new ProductDTO1(product.getId(), product.getName()));
        }
        return new CategoryDTO1(category.getId(), category.getName(), productDTO1s);

    }

    public void deleteCategory(Long id) {
        Category category = categoryrepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        categoryrepo.deleteById(id);

    }

}
