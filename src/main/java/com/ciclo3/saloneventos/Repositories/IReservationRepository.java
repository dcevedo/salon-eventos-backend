package com.ciclo3.saloneventos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciclo3.saloneventos.entities.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation,Long>{
    
}
