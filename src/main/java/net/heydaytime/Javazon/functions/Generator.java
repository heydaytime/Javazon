package net.heydaytime.Javazon.functions;

import java.time.LocalDateTime;

public class Generator {

    public static LocalDateTime generateRandomizedETA(int absDays) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        return currentDateTime.plusDays(Math.round(absDays*Math.random()));
    }

}
