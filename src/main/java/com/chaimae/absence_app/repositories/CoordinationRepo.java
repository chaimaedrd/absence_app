package com.chaimae.absence_app.repositories;

import com.chaimae.absence_app.models.Coordination;
import com.chaimae.absence_app.models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordinationRepo extends JpaRepository<Coordination,Integer> {
    List<Coordination> findAllByOrderByDateDebut();
    @Query("SELECT c FROM #{#entityName} c WHERE c.dateDebut LIKE ?1 OR c.dateFin LIKE ?1 ORDER BY c.dateDebut, c.dateFin DESC" )
    List<Coordination> findByDateDebutOrDateFin(String titre);

}
