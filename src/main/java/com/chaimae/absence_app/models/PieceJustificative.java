package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PieceJustificative {
    @Id
    @GeneratedValue
    private int idPieceJustificative;

    @Column(nullable = false)
    private String cheminFichier;

    @Column(nullable = false)
    private String intitule;

    @Column(nullable = false)
    private Date dateLivraison;

    @Column(nullable = false)
    private int etat;

    @Column(nullable = false)
    private String source;

    @ManyToOne
    @JoinColumn(name = "idAbsence", referencedColumnName = "idAbsence")
    private Absence absence;

}
