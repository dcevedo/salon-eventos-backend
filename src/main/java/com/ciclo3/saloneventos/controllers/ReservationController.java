package com.ciclo3.saloneventos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.entities.Reservation;
import com.ciclo3.saloneventos.services.ReservationService;

@RestController
@RequestMapping(value = "/api/Reservation")
public class ReservationController {
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    @RequestMapping("all")
    @GetMapping
    public ResponseEntity<List<Reservation>> getReservation(){
        List<Reservation> allReservation = reservationService.getAll();
        return new ResponseEntity<List<Reservation>>(allReservation,HttpStatus.OK);
    }

    @RequestMapping("save")
    @PostMapping
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
        Reservation postReservation = reservationService.save(reservation);
        return new ResponseEntity<Reservation>(postReservation,HttpStatus.CREATED);
    }
}
