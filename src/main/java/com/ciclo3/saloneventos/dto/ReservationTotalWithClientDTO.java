package com.ciclo3.saloneventos.dto;

import com.ciclo3.saloneventos.entities.Client;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ReservationTotalWithClientDTO {

    private Long total;

    @JsonIgnoreProperties({"client","reservation","hibernateLazyInitializer","handler"})
    private Client client;

    
    public ReservationTotalWithClientDTO(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public ReservationTotalWithClientDTO() {
    }
    
}