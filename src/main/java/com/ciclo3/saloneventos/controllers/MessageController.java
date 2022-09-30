package com.ciclo3.saloneventos.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.entities.Message;
import com.ciclo3.saloneventos.services.MessageService;

@RestController
@RequestMapping(path = "/api/Message")
public class MessageController {
    
    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @RequestMapping("all")
    @GetMapping
    public ResponseEntity<List<Message>> getMessage(){
        List<Message> allMessage = messageService.getAll();
        return new ResponseEntity<List<Message>>(allMessage,HttpStatus.OK);
    }

    @RequestMapping("save")
    @PostMapping
    public ResponseEntity<Message> saveMessage(@RequestBody Message message){
        Message postMessage =  messageService.save(message);
        return new ResponseEntity<Message>(postMessage,HttpStatus.CREATED);
    }
    
}
