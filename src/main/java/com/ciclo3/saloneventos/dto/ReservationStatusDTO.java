package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ReservationStatusDTO {
    
    private Integer completed;

    private Integer cancelled;

    public ReservationStatusDTO(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public ReservationStatusDTO(){}
}
