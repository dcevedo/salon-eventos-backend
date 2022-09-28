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
@RequestMapping("/api")
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
    public void saveCategory(@RequestBody Category category){
        categoryRepository.save(category);
    }
   
    @RequestMapping("Partyroom/save")
    @PostMapping
    public void savePartyroom(@RequestBody Partyroom partyroom){
        partyroomRepository.save(partyroom);
    }
   
    @RequestMapping("Client/save")
    @PostMapping
    public void saveCLient(@RequestBody Client client){
        clientRepository.save(client);
    }
   
    @RequestMapping("Message/save")
    @PostMapping
    public void saveMessage(@RequestBody Message message){
        messageRepository.save(message);
    }

    @RequestMapping("Reservation/save")
    @PostMapping
    public void saveReservation(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
    }

    @RequestMapping("Category/all")
    @GetMapping
    public ResponseEntity<?> getCategories(){
        List<Category> allCategories = new ArrayList<>();
        allCategories = categoryRepository.findAll();
        return new ResponseEntity<>(allCategories,HttpStatus.OK);
    }
}
