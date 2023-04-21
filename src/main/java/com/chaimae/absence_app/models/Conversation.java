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
public class Conversation {
    @Id
    @GeneratedValue
    private int idConversation;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private int etat;

    @OneToMany(mappedBy = "conversation",cascade = CascadeType.ALL)
    private List<Message> messages;

}
