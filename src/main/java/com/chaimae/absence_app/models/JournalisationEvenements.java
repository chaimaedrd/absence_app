package com.chaimae.absence_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class JournalisationEvenements {
    @Id
    @GeneratedValue
    private int idEvenement;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private String adresseIP;

    @Column(nullable = false)
    private Date DateHeure;

    @Column(nullable = false)
    private String typeEvenement;

    @Column(nullable = false)
    private String criticite;

}
