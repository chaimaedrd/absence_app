package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.JournalisationEvenements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalisationEvenementRepo extends JpaRepository<JournalisationEvenements,Integer> {
}
