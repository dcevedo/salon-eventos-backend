package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.IMessageRepository;
import com.ciclo3.saloneventos.entities.Message;

@Service
public class MessageServiceImpl implements MessageService{

    IMessageRepository messageRepository;

    public MessageServiceImpl(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAll() {
        List<Message> allMessage = messageRepository.findAll();
        return allMessage;
    }

    @Override
    public Message save(Message message) {
        messageRepository.save(message);
        Message postMessage = messageRepository.findById(message.getIdMessage())
            .orElseThrow(() -> new RuntimeException("error"));
        return postMessage;
    }

}
