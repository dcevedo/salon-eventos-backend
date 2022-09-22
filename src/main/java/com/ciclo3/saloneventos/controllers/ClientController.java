package com.ciclo3.saloneventos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.Repositories.ClientRepository;
import com.ciclo3.saloneventos.entities.Client;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientByid(@PathVariable Long id){
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Error"));
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = new ArrayList<>();
        clients = clientRepository.findAll();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        clientRepository.save(client);
        Client savedClient = clientRepository.findById(client.getId())
            .orElseThrow(() -> new RuntimeException("error"));
        return new ResponseEntity<Client>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> modifyClient(@PathVariable Long id,@RequestBody Client client){
        Client modifyClient = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("error"));
        modifyClient.setName(client.getName());
        modifyClient.setEmail(client.getEmail());
        modifyClient.setAge(client.getAge());
        clientRepository.save(modifyClient);
        return new ResponseEntity<Client>(modifyClient, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id){
        clientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
