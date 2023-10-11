package com.example.stationski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Inscription")

public class Inscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInscription")
    private Integer idInscription; // Clé primaire
    private Long numInscription;
    private Integer numSemaine;
    @ManyToOne
    private Skieur skieur;

    /*    @ManyToOne()
    @JsonIgnore
    private Cours cours;
    */
}
