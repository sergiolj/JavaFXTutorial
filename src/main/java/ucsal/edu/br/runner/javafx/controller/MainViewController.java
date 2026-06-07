package ucsal.edu.br.runner.javafx.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;

import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import ucsal.edu.br.runner.javafx.model.EventsList;
import ucsal.edu.br.runner.javafx.model.RunningEvent;
import ucsal.edu.br.runner.javafx.util.AlertUtil;
import ucsal.edu.br.runner.javafx.navigation.SceneManager;

import java.io.IOException;
import java.util.List;
/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
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
        tp_running_events.setPadding(new Insets(15));

        //Executar a leitura dos dados do BD para criar os eventos
        List<RunningEvent> runningEventList = EventsList.getInstance().getEventsList();

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/card_view.fxml"));
            Parent cardPane = loader.load();

            ECardController controller = loader.getController();
            controller.createEvent(event);

            tp_running_events.getChildren().add(cardPane);

        } catch (IOException e) {
            System.out.println("Erro ao carregar visual do cartão do evento: " + event.getTitle());
            throw new RuntimeException(e);
        }

    }


}
