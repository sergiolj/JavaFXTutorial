package ucsal.edu.br.runner.javafx.dto;

import ucsal.edu.br.runner.javafx.model.Distances;
import java.time.LocalDate;
import java.util.List;

public record EventRequestDTO(
        String tittle,
        String description,
        LocalDate date,
        List<Distances> distances,
        String imageName
){}
