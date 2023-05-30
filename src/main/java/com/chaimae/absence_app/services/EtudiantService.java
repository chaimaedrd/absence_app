package com.chaimae.absence_app.services;

import com.chaimae.absence_app.repositories.EtudiantRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantService {
    private final EtudiantRepo etudiantRepo;
}
