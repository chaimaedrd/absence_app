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
public class Niveau {
    @Id
    @GeneratedValue
    private int idNiveau;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String titre;
}
