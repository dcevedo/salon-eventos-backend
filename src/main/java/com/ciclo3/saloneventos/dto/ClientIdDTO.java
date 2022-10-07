package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ClientIdDTO {
    
    private Long idClient;

    private String name;

    public ClientIdDTO(Long idClient, String name) {
        this.idClient = idClient;
        this.name = name;
    }

    public ClientIdDTO(){}
}
