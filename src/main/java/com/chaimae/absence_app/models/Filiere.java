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

    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
    private List<Coordination> coordinations;

    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL)
    private List<Niveau> niveaux;

}
