package com.example.stationski.services;

import com.example.stationski.entities.Moniteur;

import java.util.List;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur m);

    Moniteur updateMoniteur (Moniteur m);

    Moniteur retrieveMoniteur (Integer idMoniteur);

    void deleteMoniteur( Integer idMoniteur);

    Moniteur addMoniteurAndAssignToCourse(Moniteur moniteur);

    Moniteur bestMoniteur();
}
