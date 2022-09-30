package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.CategoryRepository;
import com.ciclo3.saloneventos.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public List<Category> getAll() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    @Override
    public Category create(Category category) {
        categoryRepository.save(category);
        Category findedCategory = categoryRepository.findById(category.getId())
            .orElseThrow(() -> new RuntimeException("error"));
        return findedCategory;
    }
    
}
