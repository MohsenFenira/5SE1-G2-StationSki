package com.example.stationski.repositories;

import com.example.stationski.entities.Abonnement;
import com.example.stationski.entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Integer> {
    Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);

    List<Abonnement> getAbonnementsByDateDebutBetween(LocalDate date1, LocalDate date2);

    @Query("select distinct a from Abonnement a where a.dateFin >= CURRENT_TIME and a.dateFin <= :dateExpiration order by a.dateFin")
    List<Abonnement> findDistinctOrderByDateFinAsc(@Param("dateExpiration") LocalDate dateExpiration);
    @Query("select (sum(i.prixAbon))/(count(i)) from Abonnement i where i.typeAbon = ?1")
    Float recurringRevenueByTypeSubEquals(TypeAbonnement typeAbonnement);
}
