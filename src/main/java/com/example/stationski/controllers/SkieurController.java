package com.example.stationski.controllers;

import com.example.stationski.entities.Couleur;
import com.example.stationski.entities.Skieur;
import com.example.stationski.entities.TypeAbonnement;
import com.example.stationski.services.ISkieurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/skieur")
public class SkieurController {
    ISkieurService skieurService;
    // http://localhost:8089/stationSki/skieur/assignSkieurToPiste/15/1
    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable("numSkieur")Long numSkieur,
                                        @PathVariable("numPiste")Long numPiste) {
        Skieur skieur = skieurService.assignSkieurToPiste(numSkieur,numPiste);
        return skieur;
    }

    // http://localhost:8089/stationSki/skieur/addSkieurAndAssignToCourse/120
    @PostMapping("/addSkieurAndAssignToCourse/{numCours}")
    public Skieur addSkieurAndAssignToCourse(@RequestBody Skieur skieur,
                                      @PathVariable("numCours")Long numCours) {
        Skieur s = skieurService.addSkieurAndAssignToCourse(skieur,numCours);
        return s;
    }


    // http://localhost:8089/stationSki/skieur/retrieveSkieursByTypeAbonnement/MENSUEL
    @GetMapping("/retrieveSkieursByTypeAbonnement/{typeAbonnement}")
    public List<Skieur> retrieveSkieursByTypeAbonnement(@PathVariable("typeAbonnement") TypeAbonnement typeAbonnement) {
        List<Skieur> listSkieurs = skieurService.retrieveSkieursByTypeAbonnement(typeAbonnement);
        return listSkieurs;
    }

    // http://localhost:8089/stationSki/skieur/nombreSkieursParCouleurPiste
    @GetMapping("/nombreSkieursParCouleurPiste")
    public  HashMap<Couleur,Integer> nombreSkieursParCouleurPiste() {
        HashMap<Couleur,Integer> nombreSkieursParCouleurPiste = skieurService.nombreSkieursParCouleurPiste();
        return nombreSkieursParCouleurPiste;
    }

}
