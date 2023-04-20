package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification,Integer> {
}
