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

import com.ciclo3.saloneventos.dto.PartyroomBasicDTO;
import com.ciclo3.saloneventos.entities.Partyroom;
import com.ciclo3.saloneventos.services.PartyroomService;

@RestController
@RequestMapping(path = "/api/partyrooms")
public class PartyroomsController {

    @Autowired
    ModelMapper modelMapper;

    PartyroomService partyroomService;

    public PartyroomsController(PartyroomService partyroomService) {
        this.partyroomService = partyroomService;
    }

    @GetMapping
    public ResponseEntity<List<PartyroomBasicDTO>> getPartyrooms(){
        List<PartyroomBasicDTO> allPartyroom = partyroomService.getAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return new ResponseEntity<List<PartyroomBasicDTO>>(allPartyroom,HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<PartyroomBasicDTO> savePartyroom(@RequestBody PartyroomBasicDTO partyroom){
        PartyroomBasicDTO postPartyroom = convertToDTO(partyroomService.save(convertToEntity(partyroom)));
        return new ResponseEntity<PartyroomBasicDTO>(postPartyroom, HttpStatus.CREATED);
    }
    
    private PartyroomBasicDTO convertToDTO(Partyroom partyroom){
        PartyroomBasicDTO partyroomBasicDTO = modelMapper.map(partyroom, PartyroomBasicDTO.class);
        return partyroomBasicDTO;
    }

    private Partyroom convertToEntity(PartyroomBasicDTO partyroomBasicDTO){
        Partyroom category = modelMapper.map(partyroomBasicDTO, Partyroom.class);
        return category;
    }

}
