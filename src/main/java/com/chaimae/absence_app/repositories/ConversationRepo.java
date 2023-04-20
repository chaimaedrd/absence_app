package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepo extends JpaRepository<Conversation,Integer> {
}
