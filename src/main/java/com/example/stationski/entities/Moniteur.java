package com.example.stationski.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


    @Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Table( name = "Moniteur")
    public class Moniteur implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idMoniteur")
        private Integer idMoniteur; // Clé primaire
        private Long numMoniteur;
        private String nomM;
        private String prenomM;
        private LocalDate dateRecru;
        private float prime;

    }

