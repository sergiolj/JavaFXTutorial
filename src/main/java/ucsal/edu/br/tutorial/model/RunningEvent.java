package ucsal.edu.br.tutorial.model;

import ucsal.edu.br.tutorial.util.Distances;

import java.time.LocalDate;

public class RunningEvent {
    private final String Title;
    private final String Description;
    private final Distances Distance;
    private final LocalDate date;
    private final Double price;

    public RunningEvent(String Title, String Description, Distances Distance, LocalDate date, Double price) {
        this.Title = Title;
        this.Description = Description;
        this.Distance = Distance;
        this.date = date;
        this.price = price;
    }
}
