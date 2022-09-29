package com.ciclo3.saloneventos.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name= "description")
    private String description;

    @OneToMany(mappedBy = "category",
                cascade = CascadeType.PERSIST,
                orphanRemoval = true)
    @JsonIgnoreProperties("category")
    private Set<Partyroom> partyrooms = new HashSet<>();

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category(){}

}
