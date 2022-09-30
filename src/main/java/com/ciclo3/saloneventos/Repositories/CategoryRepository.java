package com.ciclo3.saloneventos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclo3.saloneventos.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
