package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Module {
    @Id
    @GeneratedValue
    private int idModule;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String code;

    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL)
    private List<Matiere> matieres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNiveau" , referencedColumnName = "idNiveau")
    private Niveau niveau;

}
