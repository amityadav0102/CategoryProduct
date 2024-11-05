package com.CategoryProduct.CategoryProduct.Controller;

import com.CategoryProduct.CategoryProduct.DTO.ProductDTO;
import com.CategoryProduct.CategoryProduct.Entity.Product;
import com.CategoryProduct.CategoryProduct.Service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class Productcontroller {
    @Autowired
    Productservice productservice;

    @GetMapping
    public Page<Product> getall(Pageable pageable) {
        return productservice.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ProductDTO findbyid(@PathVariable Long id) {
        return productservice.findbyid(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productservice.creteProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateproduct(@PathVariable Long id, @RequestBody Product product) {
        return productservice.updateproduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteproduct(Long id) {
        productservice.deleteproduct(id);
    }
}
