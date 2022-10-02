package com.ciclo3.saloneventos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.dto.ReservationBasicDTO;
import com.ciclo3.saloneventos.entities.Reservation;
import com.ciclo3.saloneventos.services.ReservationService;

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationsController {

    @Autowired
    ModelMapper modelMapper;

    ReservationService reservationService;

    public ReservationsController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    @GetMapping
    public ResponseEntity<List<ReservationBasicDTO>> getReservations(){
        List<ReservationBasicDTO> allReservation = reservationService.getAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return new ResponseEntity<List<ReservationBasicDTO>>(allReservation,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
        Reservation postReservation = reservationService.save(reservation);
        return new ResponseEntity<Reservation>(postReservation,HttpStatus.CREATED);
    }

    private ReservationBasicDTO convertToDTO(Reservation reservation){
        ReservationBasicDTO reservationBasicDTO = modelMapper.map(reservation, ReservationBasicDTO.class);
        return reservationBasicDTO;
    }

    // private Reservation convertToEntity(ReservationBasicDTO reservationBasicDTO){
    //     Reservation reservation = modelMapper.map(reservationBasicDTO, Reservation.class);
    //     return reservation;
    // }

}
