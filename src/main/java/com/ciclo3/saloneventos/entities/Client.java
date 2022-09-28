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

@Entity
@Table(name="client")
@Getter @Setter
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "age")
    private Integer age;

    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "client")
    private Set<Message> message;
    
    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservation;
    
    
    public Client(){}
    
    public Client(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    public Client(String name, String email, Integer age, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }    
    public Client(String name, String email, Integer age, String password, Set<Message> message,
            Set<Reservation> reservation) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
        this.message = message;
        this.reservation = reservation;
    }
}
