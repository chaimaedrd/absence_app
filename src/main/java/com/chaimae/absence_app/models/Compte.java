package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompte;
    private int enabled = 0;
    private int accountNotExpired;
    private int accountNotLocked;
    private String login;
    private String password;
    private boolean disconnectAccount = true ;
    private boolean accepteDemandeAutorisationAbsence = true;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idUtilisateur", referencedColumnName = "idUtilisateur")
    private Utilisateur utilisateur;

    public Compte(String login, String password,Utilisateur utilisateur) {
        this.login = login;
        this.password = password;
        this.utilisateur = utilisateur;
    }

    @OneToMany(mappedBy = "compte",cascade = CascadeType.ALL)
    private List<JournalisationEvenements> journalisationEvenements;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="idRole", referencedColumnName = "idRole")
    //private Role role;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="Compte_Role",
            joinColumns = @JoinColumn(name = "comptes"),
            inverseJoinColumns = @JoinColumn(name = "roles")
    )
    private Collection<Role> roles;

    @OneToMany(mappedBy = "compte",cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "expediteur",cascade = CascadeType.ALL)
    private List<Message> messagesEnvoyer;

    @OneToMany(mappedBy = "destinataire",cascade = CascadeType.ALL)
    private List<Message> messagesRecus;

    @OneToMany(mappedBy = "createurConversation",cascade = CascadeType.ALL)
    private List<Conversation> conversationsCrees;

    @ManyToMany(mappedBy = "participant",cascade = CascadeType.ALL)
    private List<Conversation> conversationsRecus;

}
