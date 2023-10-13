package com.example.stationski.repositories;

import com.example.stationski.entities.Inscription;
import com.example.stationski.entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {

    Inscription findByNumInscription(Long numInscription);
    @Query("select inscription.numSemaine from Inscription inscription " +
            "join Moniteur moniteur " +
            "on inscription.cours member moniteur.coursSet " +
            "where moniteur.numMoniteur = :numMoniteur and inscription.cours.support = :support")
    List<Integer> numWeeksCoursOfMoniteurBySupport(@Param("numMoniteur") Long numMoniteur, @Param("support") Support support);


}
