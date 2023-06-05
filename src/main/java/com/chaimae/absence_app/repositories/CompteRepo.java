package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CompteRepo extends JpaRepository<Compte,Integer> {
    Optional<Compte> findByLogin(String login);

}
