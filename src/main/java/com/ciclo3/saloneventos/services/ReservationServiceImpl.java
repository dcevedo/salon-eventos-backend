package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.ReservationRepository;
import com.ciclo3.saloneventos.entities.Reservation;
import com.ciclo3.saloneventos.exceptions.EntityNotFoundException;

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
            .orElseThrow(() -> new EntityNotFoundException(Reservation.class));
        return postReservation;
    }

    @Override
    public Reservation getById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Reservation.class,id));
        return reservation;
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        Reservation updatedReservation = reservationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Reservation.class,id));
        updatedReservation.setStartDate(reservation.getStartDate());
        updatedReservation.setDevolutionDate(reservation.getDevolutionDate());
        updatedReservation.setStatus(reservation.getStatus());
        updatedReservation.setClient(reservation.getClient());
        updatedReservation.setPartyroom(reservation.getPartyroom());
        updatedReservation.setScore(reservation.getScore());
        reservationRepository.save(updatedReservation);
        return updatedReservation;
    }

    @Override
    public void delete(Long id) {
        Reservation reservation = reservationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Reservation.class,id));
        reservationRepository.delete(reservation);

    }
    
}
