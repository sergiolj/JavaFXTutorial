package ucsal.edu.br.runner.javafx.service;

import ucsal.edu.br.runner.javafx.dto.EventRequestDTO;
import ucsal.edu.br.runner.javafx.model.EventsList;
import ucsal.edu.br.runner.javafx.model.RunningEvent;

public class EventService {
    EventsList events = EventsList.getInstance();

    public boolean createEvent (EventRequestDTO dto) {
        RunningEvent runningEvent = new RunningEvent();
        runningEvent.setTitle(dto.tittle());
        runningEvent.setDate(dto.date());
        runningEvent.setDescription(dto.description());
        runningEvent.setImgName(dto.imageName());
        runningEvent.addListOfDistances(dto.distances());

        return events.add(runningEvent);
    }
}
