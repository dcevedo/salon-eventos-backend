package com.ciclo3.saloneventos.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ScoreBasicDTO {

    private Long idScore;

    private Integer value;

    private Set<ReservationIdDTO> reservations;


    public ScoreBasicDTO(Long idScore, Integer value, Set<ReservationIdDTO> reservations) {
        this.idScore = idScore;
        this.value = value;
        this.reservations = reservations;
    }


    public ScoreBasicDTO() {
    }

}
