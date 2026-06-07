package ucsal.edu.br.tutorial.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ucsal.edu.br.tutorial.util.Distances.*;

public class EventsMockup {

    public static List<RunningEvent> mockUpData() {
        ArrayList<RunningEvent> events = new ArrayList<>();
        events.add(new RunningEvent("Meia Maratona da Bahia",
                "A melhor corrida da Bahia em sua 15ed.",
                D21K, LocalDate.of(2026,9,25), 120.0,"default.jpg"));
        events.add(new RunningEvent("Circuito das Estações",
                "Etapa Primavera",
                D5K, LocalDate.of(2026,8,5), 100.0,"default.jpg"));
        events.add(new RunningEvent("Maratona de Salvador",
                "A maratona dos cartões postais da orla de Salvador",
                D42K, LocalDate.of(2026,10,10), 150.0,"default.jpg"));
        events.add(new RunningEvent("Maratona da UCSAL",
                "A maratona da universidade católica do Salvador.",
                D42K, LocalDate.of(2026,12,20), 130.0,"default.jpg"));
        events.add(new RunningEvent("Night Run de inverno",
                "Mais que uma corrida, uma festa!",
                D10K, LocalDate.of(2026,6,10), 140.0,"default.jpg"));
        return events;
    }
}
