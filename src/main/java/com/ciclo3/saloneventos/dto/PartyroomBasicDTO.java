package com.ciclo3.saloneventos.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PartyroomBasicDTO {
    
    private Long id;

    private String name;

    private String owner;

    private Integer capacity;

    private String description;

    private CategoryIdDTO category;

    private Set<MessageIdDTO> messages = new HashSet<>();

    private Set<ReservationIdDTO> reservations = new HashSet<>();

    
    public PartyroomBasicDTO(Long id, String name, String owner, Integer capacity, String description,
            CategoryIdDTO category, Set<MessageIdDTO> messages, Set<ReservationIdDTO> reservations) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.capacity = capacity;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }



    public PartyroomBasicDTO() {
    }

}
