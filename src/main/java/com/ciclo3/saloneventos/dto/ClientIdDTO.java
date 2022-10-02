package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ClientIdDTO {
    
    private Long idCLient;

    private String name;

    public ClientIdDTO(Long idCLient, String name) {
        this.idCLient = idCLient;
        this.name = name;
    }

    public ClientIdDTO(){}
}
