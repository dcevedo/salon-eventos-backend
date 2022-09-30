package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.Repositories.IReservationRepository;
import com.ciclo3.saloneventos.entities.Reservation;

public class ReservationServiceImpl implements ReservationService {

    IReservationRepository reservationRepository;

    public ReservationServiceImpl(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAll() {
      List<Reservation> allReservation = reservationRepository.findAll();
      return allReservation;
    }

    @Override
    public Reservation save(Reservation reservation) {        
        reservationRepository.save(reservation);
        Reservation postReservation = reservationRepository.findById(reservation.getIdReservation())
            .orElseThrow(() -> new RuntimeException("error"));
        return postReservation;
    }
    
}
