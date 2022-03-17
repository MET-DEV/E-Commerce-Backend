package com.metsoft.ecommerce.api.controller;

import com.metsoft.ecommerce.model.Category;
import com.metsoft.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/categories/")
public class CategoriesController {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("getall")
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
