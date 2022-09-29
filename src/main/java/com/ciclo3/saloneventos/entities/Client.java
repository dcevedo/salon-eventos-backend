package com.ciclo3.saloneventos.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="client")
@Getter @Setter
@ToString
// @JsonIdentityInfo(
//   generator = ObjectIdGenerators.PropertyGenerator.class, 
//   property = "idClient")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idClient;
    
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;
        
    @Column(name = "age")
    private int age;
    
    @OneToMany(mappedBy = "client",
                cascade = {CascadeType.PERSIST},
                orphanRemoval = true)
    @JsonIgnoreProperties("client")
    private Set<Message> messages;
        
    @OneToMany(mappedBy = "client",
                cascade = {CascadeType.PERSIST},
                orphanRemoval = true)
    @JsonIgnoreProperties("client")
    private Set<Reservation> reservations;
    
    
    public Client(){}
    
    public Client(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    public Client(String name, String email, int age, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }    
    // public Client(String name, String email, Integer age, String password, Set<Message> message,
    //         Set<Reservation> reservation) {
    //     this.name = name;
    //     this.email = email;
    //     this.age = age;
    //     this.password = password;
    //     this.message = message;
    //     this.reservation = reservation;
    // }
}
