package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.TypeSeance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeSeanceRepo extends JpaRepository<TypeSeance,Integer> {
}
