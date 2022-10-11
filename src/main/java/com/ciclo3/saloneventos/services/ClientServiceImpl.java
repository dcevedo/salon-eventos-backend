package com.ciclo3.saloneventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.ClientRepository;
import com.ciclo3.saloneventos.entities.Client;
import com.ciclo3.saloneventos.exceptions.EntityMalformedException;
import com.ciclo3.saloneventos.exceptions.EntityNotFoundException;
import com.ciclo3.saloneventos.utils.Utility;

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
        this.verificateEntity(client);
        clientRepository.save(client);
        Client postClient = clientRepository.findById(client.getIdClient())
            .orElseThrow(() -> new EntityNotFoundException(Client.class));
        return postClient;
    }

    private void verificateEntity(Client client) {

        if(!Utility.onlyLettersMatches(client.getName())){
            throw new EntityMalformedException("the name must contain only letters");
        }

        if(!Utility.emailPatternMatches(client.getEmail())){
            throw new EntityMalformedException("email is malformed");
        }
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
        Optional.ofNullable(client.getAge()).ifPresent(updateClient::setAge);
        Optional.ofNullable(client.getEmail()).ifPresent(updateClient::setEmail);
        Optional.ofNullable(client.getName()).ifPresent(updateClient::setName);
        Optional.ofNullable(client.getPassword()).ifPresent(updateClient::setPassword);
        clientRepository.save(updateClient);
        return updateClient;
    }

    @Override
    public void update(Client client) {
        Client updateClient = clientRepository.findById(client.getIdClient())
            .orElseThrow(() -> new EntityNotFoundException(Client.class));
        Optional.ofNullable(client.getAge()).ifPresent(updateClient::setAge);
        Optional.ofNullable(client.getEmail()).ifPresent(updateClient::setEmail);
        Optional.ofNullable(client.getName()).ifPresent(updateClient::setName);
        Optional.ofNullable(client.getPassword()).ifPresent(updateClient::setPassword);
        clientRepository.save(updateClient);
    }

    @Override
    public void delete(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Client.class,id));
        clientRepository.delete(client);        
    }
    
}
