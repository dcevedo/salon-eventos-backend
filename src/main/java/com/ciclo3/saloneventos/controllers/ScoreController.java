package com.ciclo3.saloneventos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.entities.Score;
import com.ciclo3.saloneventos.services.ScoreService;

@RestController
@RequestMapping(value = "/api/Score")
public class ScoreController {
    
    ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }
    
    @GetMapping
    @RequestMapping("all")
    public ResponseEntity<List<Score>> getReservations(){
        List<Score> scores = scoreService.getAll();
        return new ResponseEntity<List<Score>>(scores,HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("save")
    public ResponseEntity<Score> saveReservation(Score score){
        Score postScore = scoreService.save(score);
        return new ResponseEntity<Score>(postScore,HttpStatus.CREATED);
    }
}
