package com.metsoft.ecommerce.api.controller;

import com.metsoft.ecommerce.model.Category;
import com.metsoft.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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
    @GetMapping("/getbyid/{id}")
    public ResponseEntity getCategoryById(@PathVariable int id){
        Optional<Category> category=categoryRepository.findById(id);
        if (category.isEmpty()){
            return  ResponseEntity.status(404).body("category not found");
        }
        return  ResponseEntity.ok(category);

    }


    @PostMapping("add")
    public ResponseEntity saveCategory(@RequestBody Category category){
        if (category.getId()!=0){
            return ResponseEntity.badRequest().body("id is generated value. You cannot assign.");
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PatchMapping("update")
    public ResponseEntity updateCategory(@RequestBody Category category) {
        if(category.getId()==0){
            return  ResponseEntity.badRequest().body("id is required");
        }
        return  ResponseEntity.ok(categoryRepository.save(category));

    }
    @DeleteMapping("delete")
    public ResponseEntity deleteCategory(@RequestBody Category category){
        if (category.getId()==0){
            return  ResponseEntity.badRequest().body("id is required");
        }
        categoryRepository.deleteById(category.getId());
        return ResponseEntity.ok("Deleted");

    }



}
