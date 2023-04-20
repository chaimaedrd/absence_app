package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepo extends JpaRepository<Enseignant,Integer> {
}
