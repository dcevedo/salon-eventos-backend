package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ScoreBasicDTO {

    private Long idScore;

    private Integer value;

    public ScoreBasicDTO(Long idScore, Integer value) {
        this.idScore = idScore;
        this.value = value;
    }

    public ScoreBasicDTO() {
    }

}
