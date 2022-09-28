package com.ciclo3.saloneventos.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "partyroom_id")
    private Long partyroomId;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "devolutiondate")
    private Date devolutionDate;

    public Reservation(){}
    public Reservation(Date startDate, Date devolutionDate) {
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
    }

    public Reservation(Long clientId, Long partyroomId, Date startDate, Date devolutionDate) {
        this.clientId = clientId;
        this.partyroomId = partyroomId;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
    }
}
