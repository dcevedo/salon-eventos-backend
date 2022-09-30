package com.ciclo3.saloneventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.PartyroomRepository;
import com.ciclo3.saloneventos.entities.Partyroom;

@Service
public class PartyroomServiceImpl implements PartyroomService{

    PartyroomRepository partyroomRepository;

    
    public PartyroomServiceImpl(PartyroomRepository partyroomRepository) {
        this.partyroomRepository = partyroomRepository;
    }

    @Override
    public List<Partyroom> getAll() {
        List<Partyroom> allPartyroom = partyroomRepository.findAll();
        return allPartyroom;
    }

    @Override
    public Partyroom save(Partyroom partyroom) {
        partyroomRepository.save(partyroom);
        Partyroom postPartyroom = partyroomRepository.findById(partyroom.getId())
            .orElseThrow(() -> new RuntimeException("error"));
        return postPartyroom;
    }
    
}
