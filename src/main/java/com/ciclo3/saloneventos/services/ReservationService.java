package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.entities.Reservation;

public interface ReservationService {
    
    List<Reservation> getAll();
    
    Reservation save(Reservation reservation);

    Reservation getById(Long id);

    Reservation update(Long id, Reservation reservation);

    void delete(Long id);
}
