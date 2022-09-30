package com.ciclo3.saloneventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.Repositories.IReservationRepository;
import com.ciclo3.saloneventos.Repositories.IScoreRepository;
import com.ciclo3.saloneventos.entities.Reservation;

@RestController
@RequestMapping(path = "/api")
public class Reto3Controller {
    
    @Autowired
    IReservationRepository reservationRepository;

    @Autowired
    IScoreRepository scoreRepository;

   
   
   
    @RequestMapping("Reservation/save")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveReservation(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
    }

   
    
    @RequestMapping("Reservation/all")
    @GetMapping
    public ResponseEntity<List<Reservation>> getReservation(){
        List<Reservation> allReservation = reservationRepository.findAll();
        return new ResponseEntity<List<Reservation>>(allReservation,HttpStatus.OK);
    }
}
