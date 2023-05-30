package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModule;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String code;

    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL)
    private List<Matiere> matieres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idNiveau" , referencedColumnName = "idNiveau")
    private Niveau niveau;

}
