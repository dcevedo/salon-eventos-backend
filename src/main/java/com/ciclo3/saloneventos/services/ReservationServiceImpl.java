package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.ReservationRepository;
import com.ciclo3.saloneventos.entities.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
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
