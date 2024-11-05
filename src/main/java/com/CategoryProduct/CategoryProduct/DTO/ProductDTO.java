package com.CategoryProduct.CategoryProduct.DTO;

public class ProductDTO {
    Long id;
    String name;
    CategoryDTO categoryDTO;

    public ProductDTO(Long id, String name, CategoryDTO categoryDTO) {
        this.id = id;
        this.name = name;
        this.categoryDTO = categoryDTO;
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

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
