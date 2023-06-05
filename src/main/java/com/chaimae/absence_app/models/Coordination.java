package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coordination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCoordination;

    @Column(nullable = false)
    private String dateDebut;

    @Column(nullable = false)
    private String dateFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    private Enseignant enseignant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFiliere", referencedColumnName = "idFiliere")
    private Filiere filiere;

    @Override
    public String toString() {
        return "Coordination{" +
                "idCoordination=" + idCoordination +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", enseignant=" + enseignant.getIdUtilisateur() +
                ", filiere=" + filiere.getIdFiliere() +
                '}';
    }
}
