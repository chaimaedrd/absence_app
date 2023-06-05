package com.chaimae.absence_app.services;

import com.chaimae.absence_app.repositories.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;
}
