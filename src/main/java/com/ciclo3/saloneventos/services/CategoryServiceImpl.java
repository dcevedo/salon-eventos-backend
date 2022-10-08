package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.CategoryRepository;
import com.ciclo3.saloneventos.entities.Category;
import com.ciclo3.saloneventos.exceptions.EntityNotFoundException;

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
            .orElseThrow(() -> new EntityNotFoundException(Category.class));
        return findedCategory;
    }

    @Override
    public Category getById(Long id) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Category.class,id));
        return category;
    }

    @Override
    public Category update(Long id, Category category) {
        Category updatedCategory = categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Category.class,id));
        updatedCategory.setName(category.getName());
        updatedCategory.setDescription(category.getDescription());
        categoryRepository.save(updatedCategory);
        return updatedCategory;
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Category.class,id));
        categoryRepository.delete(category);
    }
    
}
