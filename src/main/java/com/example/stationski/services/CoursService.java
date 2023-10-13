package com.example.stationski.services;

import com.example.stationski.repositories.CoursRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CoursService implements   ICoursService{
    CoursRepository coursRepository;
    //@Scheduled(cron = "*/15 * * * * *")
   /* public void listeCoursSnowBoard() {

        coursRepository.findBySupport(Support.SNOWBOARD).stream().forEach(
                cours ->
                {
                  log.info("cours "+ cours.getNumCours()+" prix :"+cours.getPrix());
                }
        );

    }*/
}
