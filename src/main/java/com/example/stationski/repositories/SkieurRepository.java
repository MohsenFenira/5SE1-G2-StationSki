package com.example.stationski.repositories;

import com.example.stationski.entities.Abonnement;
import com.example.stationski.entities.Couleur;
import com.example.stationski.entities.Skieur;
import com.example.stationski.entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkieurRepository  extends JpaRepository<Skieur,Integer> {

Skieur findByNumSkieur(Long numSkieur);
List<Skieur> findByAbonnementTypeAbon(TypeAbonnement TypeAbonnement);

Skieur findByAbonnement(Abonnement abonnement);

@Query("select s from Skieur s JOIN s.pistes p where  p.couleur=:couleur ")
List<Skieur> skieursByCouleurPiste(@Param("couleur") Couleur couleur);
}
