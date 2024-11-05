package com.CategoryProduct.CategoryProduct.Service;

import com.CategoryProduct.CategoryProduct.DTO.ProductDTO;
import com.CategoryProduct.CategoryProduct.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Productservice {

   public Page<Product> getAll(Pageable pageable);

   public ProductDTO findbyid(Long id);

   public Product creteProduct(Product product);

  public Product updateproduct(Long id, Product product);

 public  void deleteproduct(Long id);
}
