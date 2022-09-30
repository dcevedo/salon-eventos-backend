package com.ciclo3.saloneventos.dto;

import lombok.ToString;

@ToString
public class categoryDto {
    private Long id;
    private String name;
    private String description;

    public categoryDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
