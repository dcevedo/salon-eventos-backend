package com.ciclo3.saloneventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.CategoryRepository;
import com.ciclo3.saloneventos.entities.Category;
import com.ciclo3.saloneventos.exceptions.EntityMalformedException;
import com.ciclo3.saloneventos.exceptions.EntityNotFoundException;
import com.ciclo3.saloneventos.utils.Utility;

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
        // verificateEntity(category);
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
        verificateEntity(category);
        Category updatedCategory = categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Category.class,id));
        Optional.ofNullable(category.getName()).ifPresent(updatedCategory::setName);
        Optional.ofNullable(category.getDescription()).ifPresent(updatedCategory::setDescription);
        categoryRepository.save(updatedCategory);
        return updatedCategory;
    }

    @Override
    public Category update(Category category) {
        Category updatedCategory = categoryRepository.findById(category.getId())
            .orElseThrow(() -> new EntityNotFoundException(Category.class));
        Optional.ofNullable(category.getName()).ifPresent(updatedCategory::setName);
        Optional.ofNullable(category.getDescription()).ifPresent(updatedCategory::setDescription);
        categoryRepository.save(updatedCategory);
        return updatedCategory;
    }


    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Category.class,id));
        categoryRepository.delete(category);
    }
    
    private void verificateEntity(Category category) {

        if(!Utility.onlyLettersMatches(category.getName())){
            throw new EntityMalformedException("the name must contain only letters");
        }

    }
}
