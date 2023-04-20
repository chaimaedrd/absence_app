package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepo extends JpaRepository<Inscription,Integer> {
}
