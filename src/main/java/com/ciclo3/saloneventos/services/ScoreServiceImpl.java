package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.ScoreRepository;
import com.ciclo3.saloneventos.entities.Score;

@Service
public class ScoreServiceImpl implements ScoreService{

    ScoreRepository scoreRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<Score> getAll() {
        List<Score> scores = scoreRepository.findAll();
        return scores;
    }

    @Override
    public Score save(Score score) {
        scoreRepository.save(score);
        Score postScore = scoreRepository.findById(score.getIdScore())
            .orElseThrow(() -> new RuntimeException());
        return postScore;
    }

    @Override
    public Score getById(Long id) {
        Score score =  scoreRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("error"));
        return score;
    }
    
}
