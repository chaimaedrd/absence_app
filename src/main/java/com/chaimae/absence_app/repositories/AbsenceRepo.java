package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepo extends JpaRepository<Absence,Integer> {
}
