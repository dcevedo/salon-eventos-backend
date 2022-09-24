package com.ciclo3.saloneventos.services;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.IClientRepository;
import com.ciclo3.saloneventos.entities.Client;
import com.ciclo3.saloneventos.exceptions.ClientMalformedException;
import com.ciclo3.saloneventos.exceptions.ClientNotFoundException;

@Service
public class ClientService implements IClientService {
    
    @Autowired
    IClientRepository clientRepository;

    @Override
    public Client getClientById(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundException(id));
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Client saveAndGetClient(Client client) {
        if(NumberUtils.isDigits(client.getName())){
            throw new ClientMalformedException("el nombre del cliente no puede ser un numero");
        }
        clientRepository.save(client);
        Client savedClient = clientRepository.findById(client.getId())
            .orElseThrow(() -> new ClientNotFoundException(client.getId()));
        return savedClient;
    }

    @Override
    public Client updateAndGetClient(Long id, Client client) {
        if(NumberUtils.isDigits(client.getName())){
            throw new ClientMalformedException("el nombre del cliente no puede ser un numero");
        }
        Client modifyClient = clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundException(id));
        modifyClient.setName(client.getName());
        modifyClient.setEmail(client.getEmail());
        modifyClient.setAge(client.getAge());
        clientRepository.save(modifyClient);
        return modifyClient;
    }

    @Override
    public void deleteClient(Long id) {
        try{
            clientRepository.deleteById(id);
        }catch(IllegalArgumentException e){
            throw new ClientNotFoundException(id);
        }
    }


}
