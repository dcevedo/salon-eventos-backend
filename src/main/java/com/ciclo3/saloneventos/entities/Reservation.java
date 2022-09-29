package com.ciclo3.saloneventos.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="reservation")
@Entity
@Getter @Setter
@ToString
// @JsonIdentityInfo(
//   generator = ObjectIdGenerators.PropertyGenerator.class, 
//   property = "idReservation")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idReservation;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "devolutiondate")
    private Date devolutionDate;

    @Column(name = "status")
    private String status = "created";

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","reservations","reservation","client"})
    @JoinColumn(name = "partyroom_id")
    private Partyroom partyroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","reservations","reservation","messages"})
    @JoinColumn(name = "client_id")
    private Client client;

    // @OneToOne(cascade = CascadeType.PERSIST,
    //             orphanRemoval = true)
    // @JoinColumn(name ="score_id",columnDefinition = "none")
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL )
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","reservation"})
    private Score score;


    public Reservation(){}

    public Reservation(Date startDate, Date devolutionDate) {
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
    }

    public Reservation(Client client, Partyroom partyroom, Date startDate, Date devolutionDate) {
        this.client = client;
        this.partyroom = partyroom;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
    }
}
