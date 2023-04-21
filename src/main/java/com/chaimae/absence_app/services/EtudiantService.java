package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Etudiant;
import com.chaimae.absence_app.repositories.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepo etudiantRepo;

    public List<Etudiant> findByNom(String nom){
        return etudiantRepo.findByNom(nom);
    }

    public Etudiant save(Etudiant etudiant){
        return etudiantRepo.save(etudiant);
    }

    public void delete(Etudiant etudiant){
        etudiantRepo.delete(etudiant);
    }

    public Etudiant saveAndFlush(Etudiant etudiant){
        return etudiantRepo.saveAndFlush(etudiant);
    }

    public Etudiant findByCne(String cne){
        return etudiantRepo.findByCne(cne);
    }
}
