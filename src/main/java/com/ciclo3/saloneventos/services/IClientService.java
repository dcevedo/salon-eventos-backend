package com.ciclo3.saloneventos.services;

import java.util.List;
import com.ciclo3.saloneventos.entities.Client;


public interface IClientService {

    Client getClientById(Long id);

    List<Client> getAllClients();

    Client saveAndGetClient(Client client);

    Client updateAndGetClient(Long id, Client client);

    void deleteClient(Long id);
}