package ucsal.edu.br.runner.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import ucsal.edu.br.runner.javafx.model.RunningEvent;
import ucsal.edu.br.runner.javafx.util.Date;

import java.util.Objects;
/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
public class ECardController {

    @FXML
    private Button btn_add_chart;

    @FXML
    private ImageView img_eventRun;

    @FXML
    private Label lbl_tittle, lbl_distance, lbl_date;

  public void createEvent(RunningEvent event) {
      lbl_tittle.setText(event.getTitle());
      lbl_distance.setText(event.getDistance());
      lbl_date.setText(Date.format(event.getDate()));

      btn_add_chart.setOnAction(action ->{
          System.out.println("Usuário clicou para comprar a corrida: " + event.getTitle());
      });

      img_eventRun.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(event.getImgPath()))));
  }
}
