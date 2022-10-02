package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PartyroomIdDTO {
    
    private Long id;

    private String name;

    public PartyroomIdDTO() {
    }

    public PartyroomIdDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    
}
