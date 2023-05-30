package com.chaimae.absence_app;

import com.chaimae.absence_app.models.Compte;
import com.chaimae.absence_app.models.Role;
import com.chaimae.absence_app.models.Utilisateur;
import com.chaimae.absence_app.repositories.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class AbsenceAppApplication {

    @Autowired
    private CompteRepo compteRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(AbsenceAppApplication.class, args);
    }
}
