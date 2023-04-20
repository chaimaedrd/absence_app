package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepo extends JpaRepository<Module,Integer> {
}
