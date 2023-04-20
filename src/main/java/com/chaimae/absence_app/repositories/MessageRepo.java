package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Integer> {
}
