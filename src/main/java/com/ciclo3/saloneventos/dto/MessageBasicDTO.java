package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MessageBasicDTO {
    

    private Long idMessage;

    private String messageText;

    private PartyroomIdDTO partyroom;

    private ClientIdDTO client;

    public MessageBasicDTO() {
    }

    public MessageBasicDTO(Long idMessage, String messageText, PartyroomIdDTO partyroom, ClientIdDTO client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.partyroom = partyroom;
        this.client = client;
    }
    
    
}
