package com.CategoryProduct.CategoryProduct.Service;

import com.CategoryProduct.CategoryProduct.DTO.CategoryDTO;
import com.CategoryProduct.CategoryProduct.DTO.ProductDTO;
import com.CategoryProduct.CategoryProduct.Entity.Category;
import com.CategoryProduct.CategoryProduct.Entity.Product;
import com.CategoryProduct.CategoryProduct.Repository.Categoryrepo;
import com.CategoryProduct.CategoryProduct.Repository.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Productserviceimp implements Productservice {
    @Autowired
    Productrepo productrepo;
    @Autowired
    Categoryrepo categoryrepo;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productrepo.findAll(pageable);
    }

    @Override
    public ProductDTO findbyid(Long id) {
        Product product = productrepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        CategoryDTO categoryDTO = new CategoryDTO(product.getCategory().getId(), product.getCategory().getName());
        return new ProductDTO(product.getId(), product.getName(), categoryDTO);

    }

    @Override
    public Product creteProduct(Product product) {
        if (product.getCategory() == null || product.getCategory().getId() == null) {
            throw new RuntimeException("Category ID is required");
        }

        Category category = categoryrepo.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setCategory(category);
        return productrepo.save(product);

    }

    @Override
    public Product updateproduct(Long id, Product productdetail) {
        if (productdetail.getCategory() == null || productdetail.getCategory().getId() == null) {
            throw new RuntimeException("Category ID is required");
        }
        Product product = productrepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        Category category = categoryrepo.findById(productdetail.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        product.setName(productdetail.getName());
        return productrepo.save(product);
    }

    @Override
    public void deleteproduct(Long id) {
        Product product = productrepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        productrepo.deleteById(id);
    }


}
