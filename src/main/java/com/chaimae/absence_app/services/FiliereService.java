package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Filiere;
import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.models.Niveau;
import com.chaimae.absence_app.repositories.FiliereRepo;
import com.chaimae.absence_app.repositories.NiveauRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Filiere getFiliereById(int filiereId) {
        return filiereRepo.findById(filiereId).orElseThrow(() -> new IllegalArgumentException("Invalid filiere ID: " + filiereId));
    }

    public void saveFiliere(Filiere filiere) {
        //for(Module module : niveau.getModules())
        //moduleRepo.save(module);
        filiereRepo.save(filiere);
    }

    public List<Niveau> getNiveauxByFiliereId(int filiereId){
        Filiere filiere = filiereRepo.findByIdFiliere(filiereId);
        return filiere.getNiveaux().stream().toList();
    }
}
