package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFiliere;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private int anneeaccreditation;

    @Column(nullable = false)
    private int anneeFinaccreditation;

    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
    private List<Coordination> coordinations;

    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL)
    private List<Niveau> niveaux;

}
