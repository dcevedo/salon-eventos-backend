package com.ciclo3.saloneventos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("all")
    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> allCategories= categoryService.getAll();
        return new ResponseEntity<List<Category>>(allCategories,HttpStatus.OK);
    }
    
    @RequestMapping("save")
    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category postCategory = categoryService.create(category);
        return new ResponseEntity<Category>(postCategory,HttpStatus.CREATED);
    }

}
