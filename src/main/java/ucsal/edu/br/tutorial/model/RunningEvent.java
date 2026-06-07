package ucsal.edu.br.tutorial.model;

import ucsal.edu.br.tutorial.util.Distances;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RunningEvent {
    private final String title;
    private final String description;
    private final List<Distances> distance = new ArrayList<>();
    private final LocalDate date;
    private final Double price;
    private final String imgName;
    private final String imgPath;

    public RunningEvent(String title, String description, Distances distance, LocalDate date, Double price, String imgName) {
        this.title = title;
        this.description = description;
        this.distance.add(distance);
        this.date = date;
        this.price = price;
        this.imgName = imgName;
        this.imgPath = "/img/" + imgName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgName() {
        return imgName;
    }
    public String getImgPath() {
        return imgPath;
    }

    public void addDistance(Distances distance) {
        this.distance.add(distance);
    }

    public String getDistance() {
        StringBuilder sb = new StringBuilder();
        for (Distances distance : distance) {
            sb.append(distance.getDescription());
        }
        return sb.toString();
    }
}
