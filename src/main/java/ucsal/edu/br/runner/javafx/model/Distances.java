package ucsal.edu.br.runner.javafx.model;
/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
public enum Distances {
    D5K("5km", 5),
    D10K("10km", 10),
    D15K("15km", 15),
    D21K("21km",21),
    D42K("42km", 42);

    private final String description;
    private final int distance;

    Distances(String description, int distance) {
        this.description = description;
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return description + " " + distance;
    }
}
