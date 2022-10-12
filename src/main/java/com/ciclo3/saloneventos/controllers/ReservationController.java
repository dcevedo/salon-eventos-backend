package com.ciclo3.saloneventos.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.dto.ReservationStatusDTO;
import com.ciclo3.saloneventos.dto.ReservationTotalWithClientDTO;
import com.ciclo3.saloneventos.entities.Reservation;
import com.ciclo3.saloneventos.services.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    @GetMapping("report-dates/{start}/{end}")
    public ResponseEntity<List<Reservation>> getByStartDateReservations(@PathVariable String start,@PathVariable String end){
        List<Reservation> filterReservations = reservationService.getByStartDateBetween(stringToDate(start), stringToDate(end));
        return new ResponseEntity<List<Reservation>>(filterReservations, HttpStatus.OK);
    }

    @GetMapping("report-status")
    public ResponseEntity<ReservationStatusDTO> getReservationCountByStatus(){
        ReservationStatusDTO reservationStatusDTO = convertToStatusDTO(reservationService.getReservationCountByAllStatus());
        return new ResponseEntity<ReservationStatusDTO>(reservationStatusDTO, HttpStatus.OK);
    }

    @GetMapping("report-clients")
    public ResponseEntity<List<ReservationTotalWithClientDTO>> getReservationTotalWithClient(){
        List<ReservationTotalWithClientDTO> report = reservationService.getReservationsByClient();
        return new ResponseEntity<List<ReservationTotalWithClientDTO>>(report, HttpStatus.OK);
    }


    private ReservationStatusDTO convertToStatusDTO(Map<String,Integer> mapa){
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        ReservationStatusDTO reservationStatusDTO = mapper.convertValue(mapa, ReservationStatusDTO.class);
        return reservationStatusDTO;
    }


    private Date stringToDate(String str){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = formatter.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
