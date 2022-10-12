package com.ciclo3.saloneventos.Repositories;

// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ciclo3.saloneventos.dto.ReservationTotalWithClientDTO;
import com.ciclo3.saloneventos.entities.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
    
    Optional<List<Reservation>> findByStartDateBetween(Date start, Date end);

    // @Query(value = "select (select count(r) from reservation r where r.status='completed') as completed, (select count(r) from reservation r where r.status='cancelled') as cancelled ")
    // @Query(value = "select new com.ciclo3.saloneventos.dto.ReservationStatusDTO(r.completed,r.cancelled) from (select count(r) from Reservation r where r.status='completed') as r.completed, (select count(r) from reservation r where r.status='cancelled') as r.cancelled ")
    @Query(value =  "SELECT COUNT(u) FROM Reservation u WHERE u.status=:status")
    Integer countReservationByStatus(String status);

    // @Query(value = "SELECT COUNT(r) as reservations,Client from Reservation r GROUP BY Client")
    @Query(value = "SELECT new com.ciclo3.saloneventos.dto.ReservationTotalWithClientDTO(COUNT(r),client) from Reservation r GROUP BY r.client ORDER BY r.id ASC")
    List<ReservationTotalWithClientDTO> countReservationsByClient();
}
