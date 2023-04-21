package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Coordination {

    @Id
    @GeneratedValue
    private int idCoordination;

    @Column(nullable = false)
    private Date dateDebut;

    @Column(nullable = false)
    private Date dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    private Enseignant enseignant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFiliere", referencedColumnName = "idFiliere")
    private Filiere filiere;
}
