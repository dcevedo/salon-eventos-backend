package com.ciclo3.saloneventos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "score")
@Entity
@Getter @Setter
@ToString
public class score {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="reserve_id")
    private Long reserveId;

    @Column(name = "value")
    private Integer value;

    public score(){}
    
    public score(Integer value) {
        this.value = value;
    }

    public score(Long reserveId, Integer value) {
        this.reserveId = reserveId;
        this.value = value;
    }
}
