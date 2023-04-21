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
public class Enseignant extends Utilisateur{
    @Column(nullable = false)
    private String specialiste;

    //The cascade attribute specifies that any changes made to an Utilisateur object
    //should also be propagated to its associated Compte objects.
    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    private List<Coordination> coordinations;

    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    private List<Absence> absences;
}
