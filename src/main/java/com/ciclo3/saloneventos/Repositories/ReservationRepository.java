package com.ciclo3.saloneventos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclo3.saloneventos.entities.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
    
    Optional<List<Reservation>> findByStartDateBetween(Date start, Date end);
}
