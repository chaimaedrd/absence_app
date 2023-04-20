package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtudiantRepo extends JpaRepository<Etudiant,Integer> {
    //Rechercher par nom
    List<Etudiant> findByNom(String nom);
    //Ajouter un etudiant
    Etudiant save(Etudiant etudiant);
    //Supprimer un etudiant
    void delete(Etudiant etudiant);
    //Modifier un etudiant
    Etudiant saveAndFlush(Etudiant etudiant);
    //Rechercher par cne
    @Query("SELECT e FROM Etudiant e WHERE e.cne LIKE %:cne%")
    Etudiant findByCne(String cne);
    // afficher la liste des etudiant d'une classe
    // Imprimer la liste des etudiant d'une classe
    // Exporter au format CSV les listes des etudiants
    // Statistique des etudiants par classe

}
