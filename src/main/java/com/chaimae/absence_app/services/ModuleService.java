package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Matiere;
import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.repositories.MatiereRepo;
import com.chaimae.absence_app.repositories.ModuleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {
    @Autowired
    private ModuleRepo moduleRepo;

    public Module delete(int id){
        Module module = moduleRepo.findById(id).get();
        moduleRepo.deleteById(module.getIdModule());
        return module;
    }

    public List<Module> getModulesByIds(int[] moduleIds) {
        // Implement the logic to fetch contacts from the database based on the provided IDs
        return moduleRepo.findByIdModuleIn(moduleIds);
    }
}
