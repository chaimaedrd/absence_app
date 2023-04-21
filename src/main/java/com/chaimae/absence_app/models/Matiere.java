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
public class Matiere {
    @Id
    @GeneratedValue
    private int idMatiere;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String code;

    //The cascade attribute specifies that any changes made to an Utilisateur object
    //should also be propagated to its associated Compte objects.
    //The orphanRemoval attribute specifies that any Compte objects
    //that are no longer associated with an Utilisateur should be removed from the database.
    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Absence> absences = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idModule", referencedColumnName = "idModule")
    private Module module;
}
