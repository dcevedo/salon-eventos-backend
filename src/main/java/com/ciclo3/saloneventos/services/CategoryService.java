package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.entities.Category;

public interface CategoryService {
    
    List<Category> getAll();
    
    Category create(Category category);

    Category getById(Long id);

    Category update(Long id, Category category);
    Category update(Category category);

    void delete(Long id);
}
