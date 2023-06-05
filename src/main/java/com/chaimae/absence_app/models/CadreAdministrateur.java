package com.chaimae.absence_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CadreAdministrateur extends Utilisateur{
    @Column
    private String grade;

    public CadreAdministrateur(String nom, String prenom, String email, String telephone, String nomArabe, String prenomArabe, String grade) {
        super(nom, prenom, email, telephone, nomArabe, prenomArabe);
        this.grade = grade;
    }
}
