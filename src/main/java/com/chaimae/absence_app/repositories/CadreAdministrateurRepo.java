package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.CadreAdministrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadreAdministrateurRepo extends JpaRepository<CadreAdministrateur,Integer> {
}
