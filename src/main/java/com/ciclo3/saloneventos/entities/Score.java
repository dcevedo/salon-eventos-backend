package com.ciclo3.saloneventos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @Column(name = "id", nullable = false)
    private Long idScore;

    @OneToOne
    @MapsId
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","scores","score"})
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
