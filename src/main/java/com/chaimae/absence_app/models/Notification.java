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
public class Notification {
    @Id
    @GeneratedValue
    private int idNotification;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String texte;

    @Column(nullable = false)
    private Date dateCreation;

    @Column(nullable = false)
    private int etat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idCompte", referencedColumnName = "idCompte")
    private Compte compte;
}
