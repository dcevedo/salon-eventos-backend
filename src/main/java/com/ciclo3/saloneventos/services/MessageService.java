package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.entities.Message;

public interface MessageService {

    List<Message> getAll();

    Message save(Message message);

    Message getById(Long id);

    Message update(Long id, Message message);

    void delete(Long id);

}
