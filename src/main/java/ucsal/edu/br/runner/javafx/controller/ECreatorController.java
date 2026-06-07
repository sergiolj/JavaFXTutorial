package ucsal.edu.br.runner.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import ucsal.edu.br.runner.javafx.model.EventsList;
import ucsal.edu.br.runner.javafx.model.RunningEvent;
import ucsal.edu.br.runner.javafx.model.Distances;
import ucsal.edu.br.runner.javafx.navigation.SceneManager;
import ucsal.edu.br.runner.javafx.util.AlertUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
public class ECreatorController {

    @FXML
    private Label lbl_info;
    @FXML
    private ToggleButton tgl_5k, tgl_10k, tgl_21k, tgl_42k;
    @FXML
    private DatePicker date_picker;
    @FXML
    private ImageView img_event;

    @FXML
    private Button btn_cancel, btn_create, btn_img_loader;
    @FXML
    private TextArea txa_event_description;
    @FXML
    private TextField txf_event_name;

    private final RunningEvent runningEvent = new RunningEvent();
    private List<ToggleButton> toggleButtons = new ArrayList<>();

    @FXML
    public void initialize(){
        btn_cancel.setOnAction(actionEvent -> SceneManager.loadMain());
        btn_create.setOnAction(actionEvent -> createNewEvent());
        btn_img_loader.setOnAction(actionEvent -> loadImage());

        Image image = new Image(Objects.requireNonNull(
                getClass().getResourceAsStream("/img/default.jpg")));
        img_event.setImage(image);
        toggleButtonsInit();
    }

    private void toggleButtonsInit() {
        tgl_5k.setUserData(Distances.D5K);
        tgl_10k.setUserData(Distances.D10K);
        tgl_21k.setUserData(Distances.D21K);
        tgl_42k.setUserData(Distances.D42K);

        toggleButtons = Arrays.asList(tgl_5k,tgl_10k,tgl_21k,tgl_42k);
    }

    private void createNewEvent() {
        runningEvent.setTitle(txf_event_name.getText());
        runningEvent.setDescription(txa_event_description.getText());
        runningEvent.setDate(date_picker.getValue());

        //Verifica a lista de toggleButtons para verificar quais foram selecionados e
        // adiciona isso na lista de distâncias da prova
        for(ToggleButton btn : toggleButtons){
            if(btn.isSelected()){
                runningEvent.addDistance((Distances) btn.getUserData());
            }
        }
        if(!validateEvent()){
            return;
        }

        EventsList.getInstance().add(runningEvent); //Recupera a instância Singleton do EventList e carrega o novo evento.
        SceneManager.loadMain(); //Recarrega a Scene main_view.html com o novo evento.
    }

    private boolean validateEvent() {
        Window currentWindow = btn_create.getScene().getWindow();// Necessário para vincular o alerta com a janela atual.

        String title = txf_event_name.getText();
        String description = txa_event_description.getText();
        if(title == null || title.trim().isEmpty() || description == null || description.trim().isEmpty()){
            AlertUtil.showError("Erro de validação",
                    "O título e a descrição são obrigatórios.", currentWindow);
            return false;
        }

        if(runningEvent.getDistance().isEmpty() || runningEvent.getDate() == null ){
            AlertUtil.showError("Erro de validação",
                    "Data e distância são campos obrigatórios.", currentWindow);
            return false;
        }

        if(runningEvent.getImgName() == null){
            runningEvent.setImgName("default.jpg");
        }
        return true;
    }

    private void loadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select running event image file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.gif", "*.bmp")
        );
        Stage currentStage = (Stage) btn_img_loader.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            img_event.setImage(image);
            runningEvent.setImgName(selectedFile.getName());
        }
    }
}
