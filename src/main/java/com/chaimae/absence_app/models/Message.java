package com.chaimae.absence_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Message {
    @Id
    @GeneratedValue
    private int idMessage;

    @Column(nullable = false)
    private String texte;

    @Column(nullable = false)
    private Date dateHeure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idConversation", referencedColumnName = "idConversation")
    private Conversation conversation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="messagesRecus", referencedColumnName = "idCompte")
    private Compte destinataire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="messagesEnvoyer", referencedColumnName = "idCompte")
    private Compte expediteur;
}
