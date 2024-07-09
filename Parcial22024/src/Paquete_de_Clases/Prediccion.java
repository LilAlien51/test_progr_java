package Paquete_de_Clases;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class Prediccion {
    private static final Map<MonthDayRange, String> signosYPredicciones = new HashMap<>();

    static {
        signosYPredicciones.put(new MonthDayRange(Month.MARCH, 21, Month.APRIL, 20), "Viajes");
        signosYPredicciones.put(new MonthDayRange(Month.APRIL, 21, Month.MAY, 20), "Dinero");
        signosYPredicciones.put(new MonthDayRange(Month.MAY, 21, Month.JUNE, 21), "Rumbas");
        signosYPredicciones.put(new MonthDayRange(Month.JUNE, 22, Month.JULY, 22), "Salud");
        signosYPredicciones.put(new MonthDayRange(Month.JULY, 23, Month.AUGUST, 23), "Felicidad");
        signosYPredicciones.put(new MonthDayRange(Month.AUGUST, 24, Month.SEPTEMBER, 23), "Deudas");
        signosYPredicciones.put(new MonthDayRange(Month.SEPTEMBER, 24, Month.OCTOBER, 22), "Decepción Amorosa");
        signosYPredicciones.put(new MonthDayRange(Month.OCTOBER, 23, Month.NOVEMBER, 22), "Trabajo");
        signosYPredicciones.put(new MonthDayRange(Month.NOVEMBER, 23, Month.DECEMBER, 21), "Buenas notas");
        signosYPredicciones.put(new MonthDayRange(Month.DECEMBER, 22, Month.JANUARY, 19), "Amor");
        signosYPredicciones.put(new MonthDayRange(Month.JANUARY, 20, Month.FEBRUARY, 19), "Paz Espiritual");
        signosYPredicciones.put(new MonthDayRange(Month.FEBRUARY, 20, Month.MARCH, 20), "Lotería");
    }

    public static String obtenerPrediccion(LocalDate fechaCumpleanos) {
        for (Map.Entry<MonthDayRange, String> entry : signosYPredicciones.entrySet()) {
            if (entry.getKey().isWithinRange(fechaCumpleanos)) {
                return entry.getValue();
            }
        }
        return "Sin predicción";
    }
}

class MonthDayRange {
    private final Month startMonth;
    private final int startDay;
    private final Month endMonth;
    private final int endDay;

    public MonthDayRange(Month startMonth, int startDay, Month endMonth, int endDay) {
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }

    public boolean isWithinRange(LocalDate date) {
        LocalDate startDate = LocalDate.of(date.getYear(), startMonth, startDay);
        LocalDate endDate = LocalDate.of(date.getYear(), endMonth, endDay);
        if (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
            return !date.isBefore(startDate) && !date.isAfter(endDate);
        } else {
            return !date.isBefore(startDate) || !date.isAfter(endDate);
        }
    }
}
