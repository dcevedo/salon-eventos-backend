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
    
    @ManyToOne
    @JoinColumn(name = "partyroom_id")
    private Partyroom partyroom;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    public Message(String messageText) {
        this.messageText = messageText;
    }
    public Message(String messageText, Partyroom partyroom, Client client) {
        this.messageText = messageText;
        this.partyroom = partyroom;
        this.client = client;
    }
    public Message(){}
}
