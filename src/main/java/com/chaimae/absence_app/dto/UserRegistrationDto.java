package com.chaimae.absence_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserRegistrationDto {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String nomArabe;
    private String prenomArabe;
    private String specialiste;
    private String cne;
    private String dateNaissance;
    private String grade;
    private String password;
    private String role;

}
