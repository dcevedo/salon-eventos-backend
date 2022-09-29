package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.entities.Category;

public interface CategoryService {
    
    List<Category> getAll();
    
    Category create(Category category);

}
