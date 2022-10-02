package com.ciclo3.saloneventos.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ClientBasicDTO {
    
    private Long idClient;
    
    private String email;

    private String name;

    private int age;

    private Set<MessageIdDTO> messages = new HashSet<>();

    private Set<ReservationIdDTO> reservations = new HashSet<>();

    public ClientBasicDTO(Long idClient, String email, String name, int age, Set<MessageIdDTO> messages,
            Set<ReservationIdDTO> reservations) {
        this.idClient = idClient;
        this.email = email;
        this.name = name;
        this.age = age;
        this.messages = messages;
        this.reservations = reservations;
    }

    public ClientBasicDTO() {
    }

    
}
