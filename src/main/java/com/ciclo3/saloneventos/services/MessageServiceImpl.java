package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.MessageRepository;
import com.ciclo3.saloneventos.entities.Message;
import com.ciclo3.saloneventos.exceptions.EntityNotFoundException;

@Service
public class MessageServiceImpl implements MessageService{

    MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
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
            .orElseThrow(() -> new EntityNotFoundException(Message.class));
        return postMessage;
    }

    @Override
    public Message getById(Long id) {
        Message message = messageRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Message.class,id));
        return message;
    }

    @Override
    public Message update(Long id, Message message) {
        Message updateMessage = messageRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Message.class,id));
        updateMessage.setMessageText(message.getMessageText());
        updateMessage.setClient(message.getClient());
        updateMessage.setPartyroom(message.getPartyroom());
        messageRepository.save(updateMessage);
        return updateMessage;
    }

    @Override
    public void delete(Long id) {
        Message message = messageRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Message.class,id));
        messageRepository.delete(message);
    }

}
