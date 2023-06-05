package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Filiere;
import com.chaimae.absence_app.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiliereRepo extends JpaRepository<Filiere,Integer> {
    List<Filiere> findAllByOrderByTitre();
    @Query("SELECT f FROM #{#entityName} f WHERE f.code LIKE ?1 OR f.titre LIKE ?1 ORDER BY f.titre, f.code DESC" )
    List<Filiere> findByTitreOrCode(String titre);

    Filiere findByIdFiliere(int filiereId);

}
