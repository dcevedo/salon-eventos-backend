package com.ciclo3.saloneventos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.dto.ReservationBasicDTO;
import com.ciclo3.saloneventos.entities.Reservation;
import com.ciclo3.saloneventos.services.ReservationService;

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationsController {

    Log logger = LogFactory.getLog(ReservationsController.class);
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

    // @GetMapping("{id}")
    // public ResponseEntity<Reservation> getReservation(@PathVariable Long id){
    //     Reservation reservation = reservationService.getById(id);
    //     return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    // }
    @GetMapping("{id}")
    public ResponseEntity<ReservationBasicDTO> getReservation(@PathVariable Long id){
        ReservationBasicDTO reservation = convertToDTO(reservationService.getById(id));
        return new ResponseEntity<ReservationBasicDTO>(reservation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
        Reservation postReservation = reservationService.save(reservation);
        return new ResponseEntity<Reservation>(postReservation,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReservationBasicDTO> updateReservation(@PathVariable Long id, @RequestBody ReservationBasicDTO reservation){
        logger.info(reservation);
        logger.info(id);
        ReservationBasicDTO updatedReservation = convertToDTO(reservationService.update(id, convertToEntity(reservation)));
        return new ResponseEntity<ReservationBasicDTO>(updatedReservation,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteReservation(@PathVariable Long id){
        reservationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ReservationBasicDTO convertToDTO(Reservation reservation){
        ReservationBasicDTO reservationBasicDTO = modelMapper.map(reservation, ReservationBasicDTO.class);
        return reservationBasicDTO;
    }

    private Reservation convertToEntity(ReservationBasicDTO reservationBasicDTO){
        logger.info(reservationBasicDTO);
        logger.info(Reservation.class);
        Reservation reservation = modelMapper.map(reservationBasicDTO, Reservation.class);
        return reservation;
    }

}
