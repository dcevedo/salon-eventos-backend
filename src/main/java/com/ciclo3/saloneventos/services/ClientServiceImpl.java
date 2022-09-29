package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.Repositories.IClientRepository;
import com.ciclo3.saloneventos.entities.Client;

public class ClientServiceImpl implements ClientService {

    IClientRepository clientRepository;

    
    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        List<Client> allClient = clientRepository.findAll();
        return allClient;
    }

    @Override
    public Client save(Client client) {
        clientRepository.save(client);
        Client postClient = clientRepository.findById(client.getIdClient())
            .orElseThrow(() -> new RuntimeException("error"));
        return postClient;
    }
    
}
