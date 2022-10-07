package com.ciclo3.saloneventos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.dto.MessageBasicDTO;
import com.ciclo3.saloneventos.entities.Message;
import com.ciclo3.saloneventos.services.MessageService;

@RestController
@RequestMapping(path = "/api/messages")
public class MessagesController {

    @Autowired
    ModelMapper modelMapper;
    
    MessageService messageService;

    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @GetMapping
    public ResponseEntity<List<MessageBasicDTO>> getMessages(){
        List<MessageBasicDTO> allMessage = messageService.getAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return new ResponseEntity<List<MessageBasicDTO>>(allMessage,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id){
        Message message = messageService.getById(id);
        return new ResponseEntity<Message>(message,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Message> saveMessage(@RequestBody Message message){
        Message postMessage =  messageService.save(message);
        return new ResponseEntity<Message>(postMessage,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<MessageBasicDTO> updateMessage(@PathVariable Long id, @RequestBody MessageBasicDTO message){
        MessageBasicDTO updatedMessage = convertToDTO(messageService.update(id, convertToEntity(message)));
        return new ResponseEntity<MessageBasicDTO>(updatedMessage, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMessage(@PathVariable Long id){{
        messageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }}
    
    private MessageBasicDTO convertToDTO(Message message){
        MessageBasicDTO messageBasicDTO = modelMapper.map(message, MessageBasicDTO.class);
        return messageBasicDTO;
    }

    private Message convertToEntity(MessageBasicDTO messageBasicDTO){
        Message message = modelMapper.map(messageBasicDTO, Message.class);
        return message;
    }
}
