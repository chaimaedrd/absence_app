package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Filiere;
import com.chaimae.absence_app.models.Niveau;
import com.chaimae.absence_app.repositories.FiliereRepo;
import com.chaimae.absence_app.repositories.NiveauRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FiliereService {
    @Autowired
    private FiliereRepo filiereRepo;

    public Filiere delete(int id){
        Filiere filiere = filiereRepo.findById(id).get();
        filiereRepo.deleteById(filiere.getIdFiliere());
        return filiere;
    }
}
