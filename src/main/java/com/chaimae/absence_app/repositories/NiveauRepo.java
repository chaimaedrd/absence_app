package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Module;
import com.chaimae.absence_app.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NiveauRepo extends JpaRepository<Niveau,Integer> {
    List<Niveau> findAllByOrderByTitre();
    @Query("SELECT n FROM #{#entityName} n WHERE n.titre LIKE ?1 OR n.alias LIKE ?1 ORDER BY n.titre, n.alias DESC" )
    List<Niveau> findByTitreOrAlias(String titre);

    Niveau findByIdNiveau(int niveauId);

    List<Niveau> findByIdNiveauIn(int[] niveauIds);
}
