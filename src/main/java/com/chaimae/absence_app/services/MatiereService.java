package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Matiere;
import com.chaimae.absence_app.repositories.MatiereRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatiereService {
    @Autowired
    private MatiereRepo matiereRepo;

    public Matiere delete(int id){
        Matiere matiere = matiereRepo.findById(id).get();
        matiereRepo.deleteById(matiere.getIdMatiere());
        return matiere;
    }
}
