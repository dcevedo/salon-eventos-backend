package com.ciclo3.saloneventos.entities;

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

@Table(name = "score")
@Entity
@Getter @Setter
@ToString
public class Score {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="reserve_id")
    private Reservation reservation;

    @Column(name = "value")
    private Integer value;

    public Score(){}
    
    public Score(Integer value) {
        this.value = value;
    }

    public Score(Reservation reservation, Integer value) {
        this.reservation = reservation;
        this.value = value;
    }
}
