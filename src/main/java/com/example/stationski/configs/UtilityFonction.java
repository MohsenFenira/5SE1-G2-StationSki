package com.example.stationski.configs;

import java.time.LocalDate;
import java.time.Period;

public class UtilityFonction {

    public static int calculateAge(LocalDate dob)
    {

        LocalDate curDate = LocalDate.now();
        if ((dob != null) && (curDate != null))
        {
            return Period.between(dob, curDate).getYears();
        }
        else
        {
            return 0;
        }
    }
}
