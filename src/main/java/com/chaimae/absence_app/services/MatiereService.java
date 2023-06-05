package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Matiere;
import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.repositories.MatiereRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Matiere> getMatieresByIds(int[] matiereIds) {
        // Implement the logic to fetch contacts from the database based on the provided IDs
        return matiereRepo.findByIdMatiereIn(matiereIds);
    }
}
