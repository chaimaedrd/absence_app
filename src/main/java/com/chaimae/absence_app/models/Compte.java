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
public class Compte {
    @Id
    @GeneratedValue
    private int idCompte;

    @Column(nullable = false)
    private int enabled;

    @Column(nullable = false)
    private int accountNotExpired;

    @Column(nullable = false)
    private int accountNotLocked;

    @Column(nullable = false)
    private int login;

    @Column(nullable = false)
    private int password;

    @Column(nullable = false)
    private boolean disconnectAccount;

    @Column(nullable = false)
    private boolean accepteDemandeAutorisationAbsence;

    @Column(nullable = false)
    private boolean affichePhoto;

    @Column(nullable = false)
    private boolean afficheEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idUtilisateur", referencedColumnName = "idUtilisateur")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "compte",cascade = CascadeType.ALL)
    private List<JournalisationEvenements> journalisationEvenements;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idRole", referencedColumnName = "idRole")
    private Role role;

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
