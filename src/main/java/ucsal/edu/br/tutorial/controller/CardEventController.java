package ucsal.edu.br.tutorial.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import ucsal.edu.br.tutorial.model.RunningEvent;

import java.util.Objects;

public class CardEventController {

    @FXML
    private Button btn_add_chart;

    @FXML
    private ImageView img_eventRun;

    @FXML
    private Label lbl_distance;

    @FXML
    private Label lbl_tittle;

  public void createEvent(RunningEvent event) {
      lbl_tittle.setText(event.getTitle());
      lbl_distance.setText("Distância: " + event.getDistance());

      btn_add_chart.setOnAction(action ->{
          System.out.println("Usuário clicou para comprar a corrida: " + event.getTitle());
      });

      img_eventRun.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(event.getImgPath()))));
  }
}
