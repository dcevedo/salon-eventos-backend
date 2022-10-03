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

    @Override
    public Reservation getById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("error"));
        return reservation;
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        Reservation updatedReservation = reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("error"));
        updatedReservation.setStartDate(reservation.getStartDate());
        updatedReservation.setDevolutionDate(reservation.getDevolutionDate());
        updatedReservation.setStatus(reservation.getStatus());
        updatedReservation.setClient(reservation.getClient());
        updatedReservation.setPartyroom(reservation.getPartyroom());
        updatedReservation.setScore(reservation.getScore());
        reservationRepository.save(updatedReservation);
        return null;
    }

    @Override
    public void delete(Long id) {
        Reservation reservation = reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("error"));
        reservationRepository.delete(reservation);

    }
    
}
