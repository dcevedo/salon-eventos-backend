package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CategoryIdDTO {
    private Long id;
    private String name;

    
    public CategoryIdDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public CategoryIdDTO(){}
}
