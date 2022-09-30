package com.ciclo3.saloneventos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclo3.saloneventos.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long>{
    
}
