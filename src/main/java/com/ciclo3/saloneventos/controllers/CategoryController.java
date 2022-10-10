package com.ciclo3.saloneventos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.entities.Category;
import com.ciclo3.saloneventos.services.CategoryService;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> allCategories= categoryService.getAll();
        return new ResponseEntity<List<Category>>(allCategories,HttpStatus.OK);
    }
    
    @PostMapping("save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category postCategory = categoryService.create(category);
        return new ResponseEntity<Category>(postCategory,HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<HttpStatus> updateCategory(@RequestBody Category category){
        categoryService.update(category);
        return new ResponseEntity<>(HttpStatus.CREATED); 
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
    }
}
