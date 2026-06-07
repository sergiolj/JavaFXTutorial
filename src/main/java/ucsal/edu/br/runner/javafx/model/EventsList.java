package ucsal.edu.br.runner.javafx.model;

import java.time.LocalDate;
import java.util.ArrayList;

import static ucsal.edu.br.runner.javafx.model.Distances.*;
/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
public class EventsList {
    private static EventsList instance;
    private static ArrayList<RunningEvent> events;

    private EventsList() {
            events = new ArrayList<>();
    }

    public static EventsList getInstance() {
        if(instance == null) {
            instance = new EventsList();
            mockUpData();
        }
        return instance;
    }

    public boolean add(RunningEvent event) {
        if (event != null) {
            events.add(event);
            System.out.println("Novo evento adicionado");
            return  true;
        }
            System.out.println("Erro: nenhum evento para adicionar");
            return false;
    }

    public ArrayList<RunningEvent> getEventsList() {
        return events;
    }

    private static void mockUpData() {
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
    }
}
