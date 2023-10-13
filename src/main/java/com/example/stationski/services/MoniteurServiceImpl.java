package com.example.stationski.services;

import com.example.stationski.entities.Moniteur;
import com.example.stationski.repositories.CoursRepository;
import com.example.stationski.repositories.MoniteurRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j

public class MoniteurServiceImpl implements IMoniteurService{
    MoniteurRepository moniteurRepository;
    CoursRepository coursRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur m) {
        return moniteurRepository.save(m);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur m) {
        return moniteurRepository.save(m);
    }

    @Override
    public Moniteur retrieveMoniteur(Integer idMoniteur) {
        return moniteurRepository.findById(idMoniteur).get();
    }

    @Override
    public void deleteMoniteur(Integer idMoniteur) {
        moniteurRepository.deleteById(idMoniteur);
    }

    @Transactional
    public Moniteur addMoniteurAndAssignToCourse(Moniteur moniteur) {
        Moniteur m1 = Moniteur.builder().build();
        Moniteur m = moniteurRepository.save(moniteur);
        return m;
    }

    @Override
    public Moniteur  bestMoniteur() {
        AtomicReference<Moniteur> bestMoniteur = new AtomicReference<>();
        AtomicReference<Integer> nbCoursMax= new AtomicReference<>(0);

        moniteurRepository.findAll().stream().forEach(

                moniteur -> {
                    if(moniteur.getCoursSet().size()> nbCoursMax.get())
                    {
                        nbCoursMax.set(moniteur.getCoursSet().size());
                        bestMoniteur.set(moniteur);
                    }


                }
        );
        log.info("bestMoniteur: "+bestMoniteur.get().getIdMoniteur()+" " +bestMoniteur.get().getNomM()+" "+ bestMoniteur.get().getPrenomM());
        log.info("nbCoursMax: "+nbCoursMax.get());
        bestMoniteur.get().setPrime(10000);
        moniteurRepository.save(bestMoniteur.get());
        log.debug(bestMoniteur.get()+"");
        return bestMoniteur.get();
    }
}
