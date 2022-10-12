package com.ciclo3.saloneventos.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ciclo3.saloneventos.dto.ReservationTotalWithClientDTO;
import com.ciclo3.saloneventos.entities.Reservation;

public interface ReservationService {
    
    List<Reservation> getAll();
    
    Reservation save(Reservation reservation);

    Reservation getById(Long id);

    Reservation update(Long id, Reservation reservation);

    void delete(Long id);

    List<Reservation> getByStartDateBetween(Date start, Date end);

    Map<String,Integer> getReservationCountByAllStatus();

    List<ReservationTotalWithClientDTO> getReservationsByClient();
}
