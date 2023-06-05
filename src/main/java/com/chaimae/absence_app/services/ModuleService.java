package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Matiere;
import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.models.Niveau;
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

    public Module getModuleById(int moduleId) {
        return moduleRepo.findById(moduleId).orElseThrow(() -> new IllegalArgumentException("Invalid module ID: " + moduleId));
    }

    public void saveModule(Module module) {
        //for(Module module : niveau.getModules())
        //moduleRepo.save(module);
        moduleRepo.save(module);
    }

    public List<Matiere> getMatieresByModuleId(int moduleId){
        Module module = moduleRepo.findByIdModule(moduleId);
        return module.getMatieres().stream().toList();
    }
}
