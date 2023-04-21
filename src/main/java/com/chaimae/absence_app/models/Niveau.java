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
public class Niveau {
    @Id
    @GeneratedValue
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
