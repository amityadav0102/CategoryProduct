package com.CategoryProduct.CategoryProduct.DTO;

import java.util.List;

public class CategoryDTO1 {
    Long id;
    String name;
    List<ProductDTO1> productDTO1;

    public CategoryDTO1(Long id, String name, List<ProductDTO1> productDTO1) {
        this.id = id;
        this.name = name;
        this.productDTO1 = productDTO1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO1> getProductDTO1() {
        return productDTO1;
    }

    public void setProductDTO1(List<ProductDTO1> productDTO1) {
        this.productDTO1 = productDTO1;
    }
}
