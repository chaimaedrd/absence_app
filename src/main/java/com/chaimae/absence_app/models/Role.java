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
public class Role {
    @Id
    @GeneratedValue
    private int idRole;

    @Column(nullable = false)
    private String nomRole;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<Compte> comptes;
}
