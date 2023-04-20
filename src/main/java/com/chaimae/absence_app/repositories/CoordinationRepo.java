package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Coordination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinationRepo extends JpaRepository<Coordination,Integer> {
}
