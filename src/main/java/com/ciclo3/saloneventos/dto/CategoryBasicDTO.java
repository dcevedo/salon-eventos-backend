package com.ciclo3.saloneventos.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CategoryBasicDTO {
    
    private Long id;
    private String name;
    private String description;
    private Set<PartyroomIdDTO> partyrooms = new HashSet<>();
    
    public CategoryBasicDTO() {
    }

    public CategoryBasicDTO(Long id, String name, String description, Set<PartyroomIdDTO> partyrooms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.partyrooms = partyrooms;
    }

}
