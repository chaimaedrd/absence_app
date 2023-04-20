package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepo extends JpaRepository<Niveau,Integer> {
}
