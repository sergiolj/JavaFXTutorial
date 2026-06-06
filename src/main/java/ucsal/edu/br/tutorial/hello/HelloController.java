package ucsal.edu.br.tutorial.hello;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label label;

    private boolean on = false;

    @FXML
    protected void onHelloButtonClick() {
        label.setText("Hello World!");
        if (!on) {
            on = true;
            label.setVisible(true);
        }else{
            on = false;
            label.setVisible(false);
        }
       // label.setText("Welcome to JavaFX Application!");
    }
}
