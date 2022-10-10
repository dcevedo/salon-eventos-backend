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

import com.ciclo3.saloneventos.entities.Partyroom;
import com.ciclo3.saloneventos.services.PartyroomService;

@RestController
@RequestMapping(path = "/api/Partyroom")
public class PartyroomController {
    PartyroomService partyroomService;

    public PartyroomController(PartyroomService partyroomService) {
        this.partyroomService = partyroomService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Partyroom>> getPartyroom(){
        List<Partyroom> allPartyroom = partyroomService.getAll();
        return new ResponseEntity<List<Partyroom>>(allPartyroom,HttpStatus.OK);
    }
    
    @PostMapping("save")
    public ResponseEntity<Partyroom> savePartyroom(@RequestBody Partyroom partyroom){
        Partyroom postPartyroom = partyroomService.save(partyroom);
        return new ResponseEntity<Partyroom>(postPartyroom, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public void updatePartyroom(@RequestBody Partyroom partyroom){
        partyroomService.update(partyroom);
    }

    @DeleteMapping("{id}")
    public void deletePartyroom(@PathVariable Long id){
        partyroomService.delete(id);
    }

    
}
