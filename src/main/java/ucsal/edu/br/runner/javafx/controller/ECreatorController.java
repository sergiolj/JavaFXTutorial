package ucsal.edu.br.runner.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import ucsal.edu.br.runner.javafx.dto.EventRequestDTO;
import ucsal.edu.br.runner.javafx.model.Distances;
import ucsal.edu.br.runner.javafx.navigation.SceneManager;
import ucsal.edu.br.runner.javafx.service.EventService;
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

    private List<ToggleButton> toggleButtons = new ArrayList<>();
    private final EventService eventService = new EventService();
    private String imgName = "default.jpg";
    private final List<Distances> distances = new ArrayList<>();


    @FXML
    public void initialize(){
        btn_cancel.setOnAction(actionEvent -> SceneManager.loadMain());
        btn_create.setOnAction(actionEvent -> {
            setDistances();
            createNewEvent();
        });
        btn_img_loader.setOnAction(actionEvent -> loadImage());

        Image image = new Image(Objects.requireNonNull(
                getClass().getResourceAsStream("/img/default.jpg")));
        img_event.setImage(image);
        toggleButtonsInit();
    }

    /**
     * Cria a funcionalidade para escolha do arquivo de imagem a ser adicionado.
     */
    private void loadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select running event image file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.gif", "*.bmp")
        );

        //Cria uma referência da stage para associar com o dialog do SO de modo semelhante ao utilizado nos Alertas
        Stage currentStage = (Stage) btn_img_loader.getScene().getWindow();

        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imgName = selectedFile.getName();
            img_event.setImage(image);
        }
    }

    /**
     * Define um dado do usuário para ser adicionado aos toggleButtons, neste caso o Enum de distâncias.
     */
    private void toggleButtonsInit() {
        tgl_5k.setUserData(Distances.D5K);
        tgl_10k.setUserData(Distances.D10K);
        tgl_21k.setUserData(Distances.D21K);
        tgl_42k.setUserData(Distances.D42K);

        toggleButtons = Arrays.asList(tgl_5k,tgl_10k,tgl_21k,tgl_42k);
    }

    /**
     * Empacota os dados da interface em um dto para ser enviado para a classe service EventService para a criação
     * do novo evento e salvamento no BD.
     */
    private void createNewEvent() {
        Window currentWindow = btn_create.getScene().getWindow(); //cria a referência da janela para ser utilizada nos alertas
        if(validateEvent()){
            try {
                EventRequestDTO eventRequest = new EventRequestDTO(
                        txf_event_name.getText(),
                        txa_event_description.getText(),
                        date_picker.getValue(),
                        distances,
                        imgName
                );
                if(eventService.createEvent(eventRequest)){
                    AlertUtil.showConfirmation("Operação Confirmada",
                            "Evento " + eventRequest.tittle() + " cadastrado com sucesso.", currentWindow);
                }
                SceneManager.loadMain();
            } catch (IllegalArgumentException e) {
                AlertUtil.showError("Erro de validação.", e.getMessage(),currentWindow);
            }
        }
    }

    /**
     * Limpa a lista e faz a verificação do estado dos toggleButtons verificando quais foram selecionados e
     * adicionando esses na lista de distâncias da prova.
     */
    private void setDistances(){
        distances.clear();
            for(ToggleButton btn : toggleButtons){
                if(btn.isSelected()){
                    distances.add((Distances) btn.getUserData());
                }
            }
    }

    /**
     * Verifica os dados armazenados na interface para determinar se estão preenchidos, emitindo alertas em caso de
     * inconformidades.
     *
     * @return retorna se a validação foi bem sucedida ou não.
     */
    private boolean validateEvent() {
        Window currentWindow = btn_create.getScene().getWindow();// Necessário para vincular o alerta com a janela atual.

        String title = txf_event_name.getText();
        String description = txa_event_description.getText();

        if(title == null || title.trim().isEmpty() || description == null || description.trim().isEmpty()){
            AlertUtil.showError("Erro de validação",
                    "O título e a descrição são obrigatórios.", currentWindow);
            return false;
        }

        if(distances.isEmpty() || date_picker.getValue() == null ){
            AlertUtil.showError("Erro de validação",
                    "Data e distância são campos obrigatórios.", currentWindow);
            return false;
        }
        return true;
    }
}
