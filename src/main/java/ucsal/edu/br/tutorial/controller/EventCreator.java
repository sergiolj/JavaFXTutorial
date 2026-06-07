package ucsal.edu.br.tutorial.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ucsal.edu.br.tutorial.util.SceneManager;

import java.io.IOException;

public class EventCreator {
    @FXML
    private Button btn_cancel, btn_create;
    @FXML
    private TextArea txt_event_name;
    @FXML
    private TextField txf_event_description;
    @FXML
    private CheckBox chb_42km;

    @FXML
    public void initialize(){
        btn_cancel.setOnAction(event -> {
            SceneManager.loadMain();
        });
    }
}
