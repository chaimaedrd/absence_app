package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Enseignant extends Utilisateur{
    @Column
    private String specialiste;

    public Enseignant(String nom, String prenom, String email, String telephone, String nomArabe, String prenomArabe, String specialiste) {
        super(nom, prenom, email, telephone, nomArabe, prenomArabe);
        this.specialiste = specialiste;
    }

    //The cascade attribute specifies that any changes made to an Utilisateur object
    //should also be propagated to its associated Compte objects.
    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    private List<Coordination> coordinations;

    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    private List<Absence> absences;
}
