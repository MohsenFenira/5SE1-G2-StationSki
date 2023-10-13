package com.example.stationski.repositories;

import com.example.stationski.entities.Couleur;
import com.example.stationski.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PisteRepository extends JpaRepository<Piste,Integer> {
    Piste findByNumPiste(Long numPiste);


}
