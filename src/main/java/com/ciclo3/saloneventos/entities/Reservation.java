package com.ciclo3.saloneventos.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="reservation")
@Entity
@Getter @Setter
@ToString
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "partyroom_id")
    private Partyroom partyroom;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "devolutiondate")
    private Date devolutionDate;

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
