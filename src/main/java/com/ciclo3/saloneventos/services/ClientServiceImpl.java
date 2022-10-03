package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.ClientRepository;
import com.ciclo3.saloneventos.entities.Client;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    
    public ClientServiceImpl(ClientRepository clientRepository) {
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

    @Override
    public Client getById(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("error"));    
        return client;
    }

    @Override
    public Client update(Long id, Client client) {
        Client updateClient = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("error"));
        updateClient.setAge(client.getAge());
        updateClient.setEmail(client.getEmail());
        updateClient.setName(client.getName());
        updateClient.setPassword(client.getPassword());
        clientRepository.save(updateClient);
        return null;
    }

    @Override
    public void delete(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("error"));
        clientRepository.delete(client);        
    }
    
}
