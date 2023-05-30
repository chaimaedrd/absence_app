package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNiveau;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String titre;

    @OneToMany(mappedBy = "niveau",cascade = CascadeType.ALL)
    private List<Module> modules;

    @OneToMany(mappedBy = "niveau",cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFiliere", referencedColumnName = "idFiliere")
    private Filiere filiere;
}
