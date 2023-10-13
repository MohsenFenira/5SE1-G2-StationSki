package com.example.stationski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCours; // Clé primaire
    private Long numCours;
    private TypeCours typeCours;
    private Support support;
    private float prix;
    private Integer creneau;
    private Integer niveau;
    @OneToMany(mappedBy ="cours" )
    @JsonIgnore
    private Set<Inscription> inscriptions;
}
