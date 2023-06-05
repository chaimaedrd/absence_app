package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Coordination;
import com.chaimae.absence_app.models.Filiere;
import com.chaimae.absence_app.repositories.CoordinationRepo;
import com.chaimae.absence_app.repositories.FiliereRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoordinationService {
    @Autowired
    private CoordinationRepo coordinationRepo;

    public Coordination delete(int id){
        Coordination coordination = coordinationRepo.findById(id).get();
        coordinationRepo.deleteById(coordination.getIdCoordination());
        return coordination;
    }
}
