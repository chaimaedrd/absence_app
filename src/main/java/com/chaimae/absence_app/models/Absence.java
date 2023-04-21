package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Absence {
    @Id
    @GeneratedValue
    private int idAbsence;

    @Column(nullable = false)
    private Date dateHeureDebutAbsence;

    @Column(nullable = false)
    private Date dateHeureFinAbsence;

    @Column(nullable = false)
    private int etat;

    @Column(nullable = false)
    private String typeSaisie;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    private Enseignant enseignant;

    @OneToMany(mappedBy = "absence")
    private List<PieceJustificative> pieceJustificatives = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="idTypeSeance", referencedColumnName = "idTypeSeance")
    private TypeSeance typeSeance;

    //FetchType.LAZY : The associated entity will not be loaded from the database until it is actually needed.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMatiere" , referencedColumnName = "idMatiere")
    private Matiere matiere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInscription" , referencedColumnName = "idInscription")
    private Inscription inscription;

}
