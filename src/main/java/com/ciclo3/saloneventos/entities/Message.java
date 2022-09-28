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

@Table(name = "message")
@Entity
@Getter @Setter
@ToString
public class Message {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "messagetext")
    private String messageText;
    
    @Column(name = "partyroom_id")
    private Long partyroomId;

    @Column(name = "client_id")
    private Long clientId;
    
    public Message(String messageText) {
        this.messageText = messageText;
    }

    public Message(String messageText, Long partyroomId, Long clientId) {
        this.messageText = messageText;
        this.partyroomId = partyroomId;
        this.clientId = clientId;
    }
    
    public Message(){}
}
