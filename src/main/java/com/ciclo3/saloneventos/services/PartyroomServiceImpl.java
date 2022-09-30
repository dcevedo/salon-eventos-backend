package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.Repositories.IPartyroomRepository;
import com.ciclo3.saloneventos.entities.Partyroom;

public class PartyroomServiceImpl implements PartyroomService{

    IPartyroomRepository partyroomRepository;

    
    public PartyroomServiceImpl(IPartyroomRepository partyroomRepository) {
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
