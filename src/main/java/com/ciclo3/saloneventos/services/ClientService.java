package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.entities.Client;

public interface ClientService {
    
    List<Client> getAll();

    Client save(Client client);
}
