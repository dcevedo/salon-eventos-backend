package com.ciclo3.saloneventos.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "category")
@Entity
@Getter @Setter
@ToString
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name= "description")
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Partyroom> partyroom;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category(String name, String description, Set<Partyroom> partyroom) {
        this.name = name;
        this.description = description;
        this.partyroom = partyroom;
    }

    public Category(){}

}
