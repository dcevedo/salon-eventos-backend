package com.ciclo3.saloneventos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.ciclo3.saloneventos.dto.CategoryBasicDTO;
import com.ciclo3.saloneventos.entities.Category;
import com.ciclo3.saloneventos.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    
    @Autowired
    ModelMapper modelMapper;

    CategoryService categoryService;

    public CategoriesController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryBasicDTO>> getCategories(){
        List<CategoryBasicDTO> allCategories= categoryService.getAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return new ResponseEntity<List<CategoryBasicDTO>>(allCategories,HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        Category category = categoryService.getById(id);
        return new ResponseEntity<Category>(category,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryBasicDTO> saveCategory(@RequestBody CategoryBasicDTO category){
        CategoryBasicDTO postCategory = convertToDTO(categoryService.create(convertToEntity(category)));
        return new ResponseEntity<CategoryBasicDTO>(postCategory,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryBasicDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryBasicDTO category){
        CategoryBasicDTO updatedCategory = convertToDTO(categoryService.update(id, convertToEntity(category)));
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CategoryBasicDTO convertToDTO(Category category){
        CategoryBasicDTO categoryBasicDTO = modelMapper.map(category, CategoryBasicDTO.class);
        return categoryBasicDTO;
    }

    private Category convertToEntity(CategoryBasicDTO categoryBasicDTO){
        Category category = modelMapper.map(categoryBasicDTO, Category.class);
        return category;
    }

}
