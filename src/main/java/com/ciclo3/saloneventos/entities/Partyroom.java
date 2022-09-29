package com.ciclo3.saloneventos.entities;

import java.util.Set;

import javax.persistence.CascadeType;
// import org.hibernate.annotations.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "partyroom")
@Entity
@Setter @Getter
@ToString
// @JsonIdentityInfo(
//   generator = ObjectIdGenerators.PropertyGenerator.class, 
//   property = "id",
//   scope = Partyroom.class)
public class Partyroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties(value = {"partyroom", "hibernateLazyInitializer","partyrooms"})
    private Category category;

    @OneToMany(mappedBy = "partyroom",
                cascade = {CascadeType.PERSIST},
                orphanRemoval = true)
    @JsonIgnoreProperties({"partyroom","client"})
    private Set<Message> messages;

    @OneToMany(mappedBy = "partyroom",
                cascade = {CascadeType.PERSIST},
                orphanRemoval = true)
    @JsonIgnoreProperties({"partyroom"})
    private Set<Reservation> reservations;

    public Partyroom(){}
    
    public Partyroom(String owner, Integer capacity, String name, String description) {
        this.owner = owner;
        this.capacity = capacity;
        this.name = name;
        this.description = description;
    }

    public Partyroom(String owner, Integer capacity, String name, String description, Category category) {
        this.owner = owner;
        this.capacity = capacity;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // public Partyroom(String owner, Integer capacity, String name, String description, Category category,
    //     Set<Message> message, Set<Reservation> reservation) {
    //     this.owner = owner;
    //     this.capacity = capacity;
    //     this.name = name;
    //     this.description = description;
    //     this.category = category;
    //     this.message = message;
    //     this.reservation = reservation;
    // }

}
