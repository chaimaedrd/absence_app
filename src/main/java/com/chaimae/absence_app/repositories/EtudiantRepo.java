package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Integer> {
}
