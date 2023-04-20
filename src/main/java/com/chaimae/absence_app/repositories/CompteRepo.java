package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte,Integer> {

}
