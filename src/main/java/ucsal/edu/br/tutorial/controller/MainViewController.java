package ucsal.edu.br.tutorial.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import ucsal.edu.br.tutorial.model.EventsMockup;
import ucsal.edu.br.tutorial.model.RunningEvent;
import ucsal.edu.br.tutorial.util.AlertUtil;
import ucsal.edu.br.tutorial.util.SceneManager;

import java.io.IOException;
import java.util.List;

public class MainViewController {
    @FXML
    private MenuItem event_create_new;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem menu_about;
    @FXML
    private TilePane tp_running_events;

    @FXML
    public void initialize() {
        //Executar a leitura dos dados do BD para criar os eventos
        List<RunningEvent> runningEventList = EventsMockup.mockUpData();

        for (RunningEvent event : runningEventList) {
            addCardEventToSelector(event);
        }
        event_create_new.setOnAction(e -> {
            SceneManager.loadEventCreator();
        });

        exit.setOnAction(event -> {
            Platform.exit();
        });

        menu_about.setOnAction(e -> {
            AlertUtil.about();
        });

    }

    private void addCardEventToSelector(RunningEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/showcase_scr/card_view.fxml"));
            Parent cardPane = loader.load();

            CardEventController controller = loader.getController();
            controller.createEvent(event);

            tp_running_events.getChildren().add(cardPane);

        } catch (IOException e) {
            System.out.println("Erro ao carregar visual do cartão do evento: " + event.getTitle());
            throw new RuntimeException(e);
        }

    }


}
