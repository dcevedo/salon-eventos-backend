package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ReservationIdDTO {

    
    private Long idReservation;
    
    public ReservationIdDTO(){

    }

    public ReservationIdDTO(Long idReservation) {
        this.idReservation = idReservation;
    }
    
    
}
