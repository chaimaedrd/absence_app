package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Integer> {
}
