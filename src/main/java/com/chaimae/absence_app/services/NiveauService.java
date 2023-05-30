package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.models.Niveau;
import com.chaimae.absence_app.repositories.ModuleRepo;
import com.chaimae.absence_app.repositories.NiveauRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NiveauService {
    @Autowired
    private NiveauRepo niveauRepo;

    @Autowired
    private ModuleRepo moduleRepo;

    public Niveau delete(int id){
        Niveau niveau = niveauRepo.findById(id).get();
        niveauRepo.deleteById(niveau.getIdNiveau());
        return niveau;
    }
    public Niveau getNiveauById(int niveauId) {
        return niveauRepo.findById(niveauId).orElseThrow(() -> new IllegalArgumentException("Invalid niveau ID: " + niveauId));
    }

    public void saveNiveau(Niveau niveau) {
        //for(Module module : niveau.getModules())
            //moduleRepo.save(module);
        niveauRepo.save(niveau);
    }

    public List<Module> getModulesByNiveauId(int niveauId){
        Niveau niveau = niveauRepo.findByIdNiveau(niveauId);
        return niveau.getModules().stream().toList();
    }
}
