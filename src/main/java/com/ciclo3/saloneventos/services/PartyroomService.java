package com.ciclo3.saloneventos.services;

import java.util.List;

import com.ciclo3.saloneventos.entities.Partyroom;

public interface PartyroomService {
    
    List<Partyroom> getAll();

    Partyroom getById(Long id);

    Partyroom save(Partyroom partyroom);

    Partyroom update(Long id, Partyroom partyroom);

    void delete(Long id);
}
