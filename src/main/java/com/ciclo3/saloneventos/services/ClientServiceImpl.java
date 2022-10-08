package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.ClientRepository;
import com.ciclo3.saloneventos.entities.Client;
import com.ciclo3.saloneventos.exceptions.EntityNotFoundException;

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
            .orElseThrow(() -> new EntityNotFoundException(Client.class));
        return postClient;
    }

    @Override
    public Client getById(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Client.class,id));
        return client;
    }

    @Override
    public Client update(Long id, Client client) {
        Client updateClient = clientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Client.class,id));
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
            .orElseThrow(() -> new EntityNotFoundException(Client.class,id));
        clientRepository.delete(client);        
    }
    
}
