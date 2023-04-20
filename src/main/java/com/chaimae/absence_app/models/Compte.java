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
public class Compte {
    @Id
    @GeneratedValue
    private int idCompte;

    @Column(nullable = false)
    private int enabled;

    @Column(nullable = false)
    private int accountNotExpired;

    @Column(nullable = false)
    private int accountNotLocked;

    @Column(nullable = false)
    private int login;

    @Column(nullable = false)
    private int password;

    @Column(nullable = false)
    private boolean disconnectAccount;

    @Column(nullable = false)
    private boolean accepteDemandeAutorisationAbsence;

    @Column(nullable = false)
    private boolean affichePhoto;

    @Column(nullable = false)
    private boolean afficheEmail;
}
