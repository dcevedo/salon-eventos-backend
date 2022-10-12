package com.ciclo3.saloneventos.services;

import java.util.Date;
// import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.ReservationRepository;
import com.ciclo3.saloneventos.dto.ReservationTotalWithClientDTO;
import com.ciclo3.saloneventos.entities.Reservation;
import com.ciclo3.saloneventos.exceptions.EntityNotFoundException;
import com.ciclo3.saloneventos.utils.Status;

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
        Optional.ofNullable(reservation.getStartDate()).ifPresent(reservation::setStartDate);
        Optional.ofNullable(reservation.getDevolutionDate()).ifPresent(reservation::setDevolutionDate);
        Optional.ofNullable(reservation.getStatus()).ifPresent(reservation::setStatus);
        Optional.ofNullable(reservation.getClient()).ifPresent(reservation::setClient);
        Optional.ofNullable(reservation.getPartyroom()).ifPresent(reservation::setPartyroom);
        Optional.ofNullable(reservation.getScore()).ifPresent(reservation::setScore);
        reservationRepository.save(updatedReservation);
        return updatedReservation;
    }

    @Override
    public void delete(Long id) {
        Reservation reservation = reservationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Reservation.class,id));
        reservationRepository.delete(reservation);

    }

    @Override
    public List<Reservation> getByStartDateBetween(Date start, Date end) {
        List<Reservation> filterReservations = reservationRepository.findByStartDateBetween(start, end)
            .orElseThrow(() -> new EntityNotFoundException(Reservation.class));
        return filterReservations; 
    }

    @Override
    public Map<String, Integer> getReservationCountByAllStatus(){
        Integer completed = reservationRepository.countReservationByStatus("completed");
        Integer cancelled = reservationRepository.countReservationByStatus("cancelled");
        Map<String,Integer> statusCount= Map.of(Status.COMPLETED.toString(),completed,
            Status.CANCELLED.toString(),cancelled);
        return statusCount;
    }

    @Override
    public List<ReservationTotalWithClientDTO> getReservationsByClient() {
        List<ReservationTotalWithClientDTO> totalWithClient = reservationRepository.countReservationsByClient();
        return totalWithClient;
    }
    
}
