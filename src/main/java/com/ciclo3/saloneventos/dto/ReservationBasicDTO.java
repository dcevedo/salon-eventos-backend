package com.ciclo3.saloneventos.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ReservationBasicDTO {

    
    private Long idReservation;
    
    private Date startDate;
    
    private Date devolutionDate;

    private String status;

    private PartyroomIdDTO partyroom;

    private ClientIdDTO client;

    private ScoreIdDTO score;

    public ReservationBasicDTO(){

    }

    public ReservationBasicDTO(Long idReservation, Date startDate, Date devolutionDate, String status,
            PartyroomIdDTO partyroom, ClientIdDTO client, ScoreIdDTO score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.partyroom = partyroom;
        this.client = client;
        this.score = score;
    }

}
