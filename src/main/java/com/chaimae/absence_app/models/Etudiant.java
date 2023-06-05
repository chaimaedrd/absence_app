package com.chaimae.absence_app.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Etudiant extends Utilisateur{
    @Column
    private String cne;

    @Column
    private String dateNaissance;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    public Etudiant(String nom, String prenom, String email, String telephone, String nomArabe, String prenomArabe, String cne, String dateNaissance) {
        super(nom, prenom, email, telephone, nomArabe, prenomArabe);
        this.cne = cne;
        this.dateNaissance = dateNaissance;
    }
}
