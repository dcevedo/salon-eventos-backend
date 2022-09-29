package com.ciclo3.saloneventos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo3.saloneventos.Repositories.ICategoryRepository;
import com.ciclo3.saloneventos.Repositories.IClientRepository;
import com.ciclo3.saloneventos.Repositories.IMessageRepository;
import com.ciclo3.saloneventos.Repositories.IPartyroomRepository;
import com.ciclo3.saloneventos.Repositories.IReservationRepository;
import com.ciclo3.saloneventos.Repositories.IScoreRepository;
import com.ciclo3.saloneventos.entities.Category;
import com.ciclo3.saloneventos.entities.Client;
import com.ciclo3.saloneventos.entities.Message;
import com.ciclo3.saloneventos.entities.Partyroom;
import com.ciclo3.saloneventos.entities.Reservation;

@RestController
@RequestMapping(path = "/api")
public class Reto3Controller {
    
    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IMessageRepository messageRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    IPartyroomRepository partyroomRepository;

    @Autowired
    IReservationRepository reservationRepository;

    @Autowired
    IScoreRepository scoreRepository;

    @RequestMapping("Category/save")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveCategory(@RequestBody Category category){
        categoryRepository.save(category);
    }
   
    @RequestMapping("Partyroom/save")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void savePartyroom(@RequestBody Partyroom partyroom){
        partyroomRepository.save(partyroom);
    }
   
    @RequestMapping("Client/save")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveCLient(@RequestBody Client client){
        clientRepository.save(client);
    }
   
    @RequestMapping("Message/save")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveMessage(@RequestBody Message message){
        messageRepository.save(message);
    }

    @RequestMapping("Reservation/save")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveReservation(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
    }

    @RequestMapping("Category/all")
    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> allCategories = categoryRepository.findAll();
        return new ResponseEntity<List<Category>>(allCategories,HttpStatus.OK);
    }
    @RequestMapping("Partyroom/all")
    @GetMapping
    public ResponseEntity<List<Partyroom>> getPartyroom(){
        List<Partyroom> allPartyroom = partyroomRepository.findAll();
        return new ResponseEntity<List<Partyroom>>(allPartyroom,HttpStatus.OK);
    }
    @RequestMapping("Client/all")
    @GetMapping
    public ResponseEntity<List<Client>> getClient(){
        List<Client> allClient = clientRepository.findAll();
        return new ResponseEntity<List<Client>>(allClient,HttpStatus.OK);
    }
    @RequestMapping("Message/all")
    @GetMapping
    public ResponseEntity<List<Message>> getMessage(){
        List<Message> allMessage = messageRepository.findAll();
        return new ResponseEntity<List<Message>>(allMessage,HttpStatus.OK);
    }
    @RequestMapping("Reservation/all")
    @GetMapping
    public ResponseEntity<List<Reservation>> getReservation(){
        List<Reservation> allReservation = reservationRepository.findAll();
        return new ResponseEntity<List<Reservation>>(allReservation,HttpStatus.OK);
    }
}
