package com.ciclo3.saloneventos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.entities.Client;
import com.ciclo3.saloneventos.services.IClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    IClientService clientService;

    @GetMapping("{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id){
        Client client = clientService.getClientById(id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findClients(){
        List<Client> clients = new ArrayList<>();
        clients = clientService.getAllClients();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client savedClient = clientService.saveAndGetClient(client);
        return new ResponseEntity<Client>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> modifyClient(@PathVariable Long id,@RequestBody Client client){
        Client modifyClient = clientService.updateAndGetClient(id,client);
        return new ResponseEntity<Client>(modifyClient, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return HttpStatus.NO_CONTENT;
    }
}
