package com.ciclo3.saloneventos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MessageIdDTO {
    

    private Long idMessage;

    private String messageText;

    public MessageIdDTO(Long idMessage, String messageText) {
        this.idMessage = idMessage;
        this.messageText = messageText;
    }

    public MessageIdDTO() {
    }
    
}
