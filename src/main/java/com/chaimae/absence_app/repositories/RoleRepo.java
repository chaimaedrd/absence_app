package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
}
