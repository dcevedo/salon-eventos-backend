package com.ciclo3.saloneventos.controllers;

import java.util.List;

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
import com.ciclo3.saloneventos.services.ClientService;

@RestController
@RequestMapping("/api/Client")
public class ClientController {
    
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Client>> getClient(){
        List<Client> allClient = clientService.getAll();
        return new ResponseEntity<List<Client>>(allClient,HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Client> saveCLient(@RequestBody Client client){
        Client postClient = clientService.save(client);
        return new ResponseEntity<Client>(postClient, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public void updateClient(@RequestBody Client client){
        clientService.update(client);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.delete(id);
    }
    
}
