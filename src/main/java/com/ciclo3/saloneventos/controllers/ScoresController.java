package com.ciclo3.saloneventos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.dto.ScoreBasicDTO;
import com.ciclo3.saloneventos.entities.Score;
import com.ciclo3.saloneventos.services.ScoreService;

@RestController
@RequestMapping(value = "/api/scores")
public class ScoresController {
    
    @Autowired
    ModelMapper modelMapper;

    ScoreService scoreService;

    public ScoresController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }
    
    @GetMapping
    public ResponseEntity<List<ScoreBasicDTO>> getScores(){
        List<ScoreBasicDTO> scores = scoreService.getAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return new ResponseEntity<List<ScoreBasicDTO>>(scores,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ScoreBasicDTO> saveReservation(ScoreBasicDTO score){
        ScoreBasicDTO postScore = convertToDTO(scoreService.save(convertToEntity(score)));
        return new ResponseEntity<ScoreBasicDTO>(postScore,HttpStatus.CREATED);
    }

    private ScoreBasicDTO convertToDTO(Score score){
        ScoreBasicDTO scoreBasicDTO = modelMapper.map(score, ScoreBasicDTO.class);
        return scoreBasicDTO;
    }

    private Score convertToEntity(ScoreBasicDTO scoreBasicDTO){
        Score score = modelMapper.map(scoreBasicDTO, Score.class);
        return score;
    }
}