package ucsal.edu.br.runner.javafx.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
public class RunningEvent {
    private String title;
    private String description;
    private final List<Distances> distance = new ArrayList<>();
    private LocalDate date;
    private Double price;
    private String imgName;
    private String imgPath;

    public RunningEvent(String title, String description, Distances distance, LocalDate date, Double price, String imgName) {
        this.title = title;
        this.description = description;
        this.distance.add(distance);
        this.date = date;
        this.price = price;
        this.imgName = imgName;
        this.imgPath = "/img/" + imgName;
    }

    public RunningEvent() {
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

    public void addListOfDistances(List<Distances> distances) {
        this.distance.addAll(distances);
    }

    public String getDistance() {
        StringBuilder sb = new StringBuilder();
        for (Distances distance : distance) {
            sb.append(distance.getDescription()).append(" ");
        }
        return sb.toString();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImgName(String name) {
        this.imgName = name;
        this.imgPath = "/img/" + name;
    }
}
