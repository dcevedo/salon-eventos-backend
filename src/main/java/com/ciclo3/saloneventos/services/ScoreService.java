package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.entities.Score;

public interface ScoreService {
    
    List<Score> getAll();

    Score save(Score score);

    Score getById(Long id);

}
