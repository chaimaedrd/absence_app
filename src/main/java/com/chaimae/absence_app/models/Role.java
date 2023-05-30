package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.DoubleStream;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(nullable = false)
    private String nomRole;

    public Role(String s){
        this.nomRole = s;
    }
    //@OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    //private List<Compte> comptes;

    //@ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    //private List<Compte> comptes;
}
