package com.example.stationski.repositories;

import com.example.stationski.entities.Cours;
import com.example.stationski.entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Integer> {
    Cours findByNumCours(Long numCours);
    List<Cours> findBySupport(Support s);
}
