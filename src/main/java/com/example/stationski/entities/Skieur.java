package com.example.stationski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "Skieur")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSkieur")
    private Integer idSkieur; // Clé primaire
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;

    @ManyToMany
    private Set<Piste> pistes;

    @OneToMany(mappedBy = "skieur",cascade = CascadeType.ALL)
    private Set<Inscription> inscriptions;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Abonnement abonnement;

}