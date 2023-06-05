package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Matiere;
import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepo extends JpaRepository<Module,Integer> {
    List<Module> findAllByOrderByTitre();
    @Query("SELECT m FROM #{#entityName} m WHERE m.titre LIKE ?1 OR m.code LIKE ?1 ORDER BY m.titre, m.code DESC" )
    List<Module> findByTitreOrCode(String titre);

    List<Module> findByIdModuleIn(int[] moduleIds);

    Module findByIdModule(int moduleId);

}
