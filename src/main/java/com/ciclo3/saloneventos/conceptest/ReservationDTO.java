package com.ciclo3.saloneventos.conceptest;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ReservationDTO {

    public ReservationDTO(){

    }

    public ReservationDTO(Date startDate, Date devolutionDate, String status) {
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
    }

    private Date startDate;
    
    private Date devolutionDate;

    private String status;

}
