package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepo extends JpaRepository<Matiere,Integer> {
}