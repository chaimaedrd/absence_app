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
public class TypeSeance {

    @Id
    @GeneratedValue
    private int idTypeSeance;

    @Column(nullable = false)
    private String intitule;

    @Column(nullable = false)
    private String alias;

    @OneToMany(mappedBy = "typeSeance")
    private List<Absence> absences = new ArrayList<>();

}
