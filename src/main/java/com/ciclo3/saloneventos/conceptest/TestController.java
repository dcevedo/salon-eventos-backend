package com.ciclo3.saloneventos.conceptest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.entities.Reservation;
import com.ciclo3.saloneventos.services.ReservationService;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ReservationService reservationService;

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<ReservationDTO> test(@PathVariable Long id){
        ReservationDTO reservationDTO = convertToDTO(reservationService.getById(id));
        return new ResponseEntity<ReservationDTO>(reservationDTO,HttpStatus.OK);
    }
    


    private ReservationDTO convertToDTO(Reservation reservation){
        ReservationDTO reservationDTO = modelMapper.map(reservation, ReservationDTO.class);
        return reservationDTO; 
    }

    private Reservation convertToEntity(ReservationDTO reservationDTO){
        Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
        return reservation;
    }
}
