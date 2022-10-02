package com.ciclo3.saloneventos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.dto.ClientBasicDTO;
import com.ciclo3.saloneventos.entities.Client;
import com.ciclo3.saloneventos.services.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {
    
    @Autowired
    ModelMapper modelMapper;

    ClientService clientService;

    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientBasicDTO>> getClients(){
        List<ClientBasicDTO> allClient = clientService.getAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return new ResponseEntity<List<ClientBasicDTO>>(allClient,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> saveCLient(@RequestBody Client client){
        Client postClient = clientService.save(client);
        return new ResponseEntity<Client>(postClient, HttpStatus.CREATED);
    }

    private ClientBasicDTO convertToDTO(Client client){
        ClientBasicDTO clientBasicDTO = modelMapper.map(client, ClientBasicDTO.class);
        return clientBasicDTO;
    }

    // private Client convertToEntity(ClientBasicDTO clientBasicDTO){
    //     Client client = modelMapper.map(clientBasicDTO, Client.class);
    //     return client;
    // }
}
