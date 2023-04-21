package com.chaimae.absence_app.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Utilisateur {
    @Id
    @GeneratedValue
    private int idUtilisateur;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String identifiant;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String nomArabe;

    @Column(nullable = false)
    private String prenomArabe;

    @Column(nullable = false)
    private String photo;
    //The cascade attribute specifies that any changes made to an Utilisateur object
    //should also be propagated to its associated Compte objects.
    //The orphanRemoval attribute specifies that any Compte objects
    //that are no longer associated with an Utilisateur should be removed from the database.
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Compte> comptes = new ArrayList<>();
}
