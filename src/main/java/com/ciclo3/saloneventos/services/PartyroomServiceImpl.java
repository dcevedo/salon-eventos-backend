package com.ciclo3.saloneventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ciclo3.saloneventos.Repositories.PartyroomRepository;
import com.ciclo3.saloneventos.entities.Partyroom;
import com.ciclo3.saloneventos.exceptions.EntityNotFoundException;

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
            .orElseThrow(() -> new EntityNotFoundException(Partyroom.class));
        return postPartyroom;
    }

    @Override
    public Partyroom getById(Long id) {
        Partyroom partyroom = partyroomRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Partyroom.class,id));
        return partyroom;
    }

    @Override
    public Partyroom update(Long id, Partyroom partyroom) {
        Partyroom updatedPartyroom = partyroomRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Partyroom.class,id));
        updatedPartyroom.setCapacity(partyroom.getCapacity());
        updatedPartyroom.setDescription(partyroom.getDescription());
        updatedPartyroom.setName(partyroom.getName());
        updatedPartyroom.setOwner(partyroom.getOwner());
        updatedPartyroom.setCategory(partyroom.getCategory());
        partyroomRepository.save(updatedPartyroom);
        return updatedPartyroom;
    }

    @Override
    public void update(Partyroom partyroom) {
        Partyroom updatedPartyroom = partyroomRepository.findById(partyroom.getId())
            .orElseThrow(() -> new EntityNotFoundException(Partyroom.class));
        Optional.ofNullable(partyroom.getCapacity()).ifPresent(updatedPartyroom::setCapacity);
        Optional.ofNullable(partyroom.getDescription()).ifPresent(updatedPartyroom::setDescription);
        Optional.ofNullable(partyroom.getName()).ifPresent(updatedPartyroom::setName);
        Optional.ofNullable(partyroom.getOwner()).ifPresent(updatedPartyroom::setName);
        Optional.ofNullable(partyroom.getCategory()).ifPresent(updatedPartyroom::setCategory);
        partyroomRepository.save(updatedPartyroom);
    }

    @Override
    public void delete(Long id) {
        Partyroom partyroom = partyroomRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Partyroom.class,id));
        partyroomRepository.delete(partyroom);
    }
    
}
