package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Matiere;
import com.chaimae.absence_app.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatiereRepo extends JpaRepository<Matiere,Integer> {

    List<Matiere> findAllByOrderByNom();
    @Query("SELECT m FROM #{#entityName} m WHERE m.nom LIKE ?1 OR m.code LIKE ?1 ORDER BY m.nom, m.code DESC" )
    List<Matiere> findByNomOrCode(String nom);

    List<Matiere> findByIdMatiereIn(int[] matiereIds);

}
