package com.ciclo3.saloneventos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.dto.ClientBasicDTO;
import com.ciclo3.saloneventos.dto.ClientPasswordDTO;
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

    @GetMapping("{id}")
    public ResponseEntity<ClientBasicDTO> getClient(@PathVariable Long id){
        ClientBasicDTO clientBasicDTO = convertToDTO(clientService.getById(id));
        return new ResponseEntity<ClientBasicDTO>(clientBasicDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientBasicDTO> saveCLient(@RequestBody ClientPasswordDTO clientPasswordDTO){
        ClientBasicDTO postClient = convertToDTO(clientService.save(convertToEntity(clientPasswordDTO)));
        return new ResponseEntity<ClientBasicDTO>(postClient, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClientBasicDTO> updateClient(@PathVariable Long id, @RequestBody ClientBasicDTO clientBasicDTO){
        ClientBasicDTO updatedClient = convertToDTO(clientService.update(id, convertToEntity(clientBasicDTO)));
        return new ResponseEntity<ClientBasicDTO>(updatedClient,HttpStatus.OK);
    }

    private ClientBasicDTO convertToDTO(Client client){
        ClientBasicDTO clientBasicDTO = modelMapper.map(client, ClientBasicDTO.class);
        return clientBasicDTO;
    }

    private Client convertToEntity(ClientBasicDTO clientBasicDTO){
        Client client = modelMapper.map(clientBasicDTO, Client.class);
        return client;
    }

    private Client convertToEntity(ClientPasswordDTO clientPasswordDTO){
        Client client = modelMapper.map(clientPasswordDTO, Client.class);
        return client;
    }

}
