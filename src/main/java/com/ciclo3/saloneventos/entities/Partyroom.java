package com.ciclo3.saloneventos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "partyroom")
@Entity
@Setter @Getter
@ToString
public class Partyroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category_id")
    private Long categoryId;

    public Partyroom(){}
    
    public Partyroom(String owner, Integer capacity, String name, String description) {
        this.owner = owner;
        this.capacity = capacity;
        this.name = name;
        this.description = description;
    }

    public Partyroom(String owner, Integer capacity, String name, String description, Long categoryId) {
        this.owner = owner;
        this.capacity = capacity;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
    }

}
