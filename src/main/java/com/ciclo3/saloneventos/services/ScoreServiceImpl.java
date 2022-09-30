package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.Repositories.IScoreRepository;
import com.ciclo3.saloneventos.entities.Score;

public class ScoreServiceImpl implements ScoreService{

    IScoreRepository scoreRepository;

    public ScoreServiceImpl(IScoreRepository scoreRepository) {
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
    
}
