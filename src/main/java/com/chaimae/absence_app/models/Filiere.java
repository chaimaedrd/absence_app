package com.chaimae.absence_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Filiere {
    @Id
    @GeneratedValue
    private int idFiliere;

    @Column(nullable = false)
    private String titreFiliere;

    @Column(nullable = false)
    private String codeFiliere;

    @Column(nullable = false)
    private int anneeaccreditation;

    @Column(nullable = false)
    private int anneeFinaccreditation;

}
