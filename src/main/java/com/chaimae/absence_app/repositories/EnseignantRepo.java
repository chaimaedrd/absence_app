package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Enseignant;
import com.chaimae.absence_app.models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant,Integer> {
    List<Enseignant> findAllByOrderByNom();
}
