package com.ciclo3.saloneventos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "message")
@Entity
@Getter @Setter
@ToString
// @JsonIdentityInfo(
//   generator = ObjectIdGenerators.PropertyGenerator.class, 
//   property = "idMessage")
public class Message {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @Column(name = "messagetext")
    private String messageText;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "partyroom_id")
    @JsonIgnoreProperties(value = {"reservations","hibernateLazyInitializer","messages","message"})
    private Partyroom partyroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties(value = {"reservations","hibernateLazyInitializer","messages","message"})
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
