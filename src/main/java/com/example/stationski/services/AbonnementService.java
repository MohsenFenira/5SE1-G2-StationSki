package com.example.stationski.services;

import com.example.stationski.entities.Abonnement;
import com.example.stationski.entities.TypeAbonnement;
import com.example.stationski.repositories.AbonnementRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.*;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class AbonnementService implements IAbonnementService{

    AbonnementRepository abonnementRepository;
    @Override
    public Set<Abonnement> getAbonnementByType(TypeAbonnement type) {
        return abonnementRepository.findByTypeAbon(type);
    }

    @Override
    public List<Abonnement> retrieveAbonnementByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.getAbonnementsByDateDebutBetween(startDate, endDate);

    }

    //@Override
//    @Scheduled(cron = "*/30 * * * * *") /* Cron expression to run a job every 30 secondes */
  /*  public void retrieveAbonnements() {
        LocalDate today = LocalDate.now();
        LocalDate dateExpiration =today.plusDays(7);
        log.info("dateExpiration : "+dateExpiration);
        for (Abonnement abonnement: abonnementRepository.findDistinctOrderByDateFinAsc(dateExpiration)) {
            Skieur aSkier = skieurRepository.findByAbonnement(abonnement);
            log.info("num abonnement : "+abonnement.getNumAbon().toString() + " | date fin Abonnement :"+ abonnement.getDateFin().toString()
                    + " |num skieur : "+ aSkier.getNumSkieur()     + " | prenom :"+ aSkier.getPrenomS() + "|nom:  " + aSkier.getNomS());
        }
    }
*/
    // @Scheduled(cron = "* 0 9 1 * *") /* Cron expression to run a job every month at 9am */
  //  @Scheduled(cron = "*/30 * * * * *") /* Cron expression to run a job every 30 secondes */
   /* public void showMonthlyRecurringRevenue() {
        Float revenue = abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.MENSUEL)
                + abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.SEMESTRIEL)/6
                + abonnementRepository.recurringRevenueByTypeSubEquals(TypeAbonnement.ANNUEL)/12;
        log.info("Monthly Revenue = " + revenue);
    }*/
}
