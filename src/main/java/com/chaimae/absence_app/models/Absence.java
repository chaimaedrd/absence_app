package com.chaimae.absence_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
}
