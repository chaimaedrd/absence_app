package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Inscription {
    @Id
    @GeneratedValue
    private int idInscription;

    @Column(nullable = false)
    private int annee;

    @Column(nullable = false)
    private int etat;

    @OneToMany(mappedBy = "inscription")
    private List<Absence> absences;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNiveau" , referencedColumnName = "idNiveau")
    private Niveau niveau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    private Etudiant etudiant;
}
