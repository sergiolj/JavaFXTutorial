package ucsal.edu.br.tutorial.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ucsal.edu.br.tutorial.util.AlertUtil;

public class LoginController {
    @FXML
    public Label lb_login_msg;
    @FXML
    private BorderPane bd_pane;
    @FXML
    private TextField tf_login_name, tf_password;

    @FXML
    private Button btn_login, btn_logout, btn_exit;

    @FXML
    public void initialize(){
        btn_login.setOnAction(event -> {
                    String login_name = tf_login_name.getText();
                    String password = tf_password.getText();
                    if (login_name.equals("admin") || password.equals("1234")) {
                        openApplication();
//                        System.out.println("Login successful");
//                        lb_login_msg.setText("Login successful");
//                        lb_login_msg.setVisible(true);
//                        lb_login_msg.setStyle("-fx-text-fill: green");
                    } else {
                        AlertUtil.showError("Login Failed", "Login Failed, name or password is incorrect.");
                    }
                });

        btn_logout.setOnAction(event ->{
            AlertUtil.showConfirmation( "Logout", "User " + tf_login_name.getText() + " logout successfully");
                tf_login_name.clear();
                tf_password.clear();
                lb_login_msg.setVisible(false);
        });

        btn_exit.setOnAction(event ->{
//            System.out.println("Shutting down application");
//            Platform.exit(); // Fecha a aplicação e não apenas a janela atual
            Stage currentWindow = (Stage) btn_exit.getScene().getWindow();
            currentWindow.close();
        });
    }

    private void openApplication() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/showcase_scr/showcase-view.fxml"));
            Parent root = loader.load();

            Scene sceneShowcase = new Scene(root, 800,600);
            Stage stage = new Stage();
            stage.setScene(sceneShowcase);
            stage.setTitle("Showcase Window");
            stage.show();
            stage.setOnShown(event -> {
                stage.centerOnScreen();
            });

            Stage loginStage = (Stage) btn_login.getScene().getWindow();
            loginStage.close();
        }catch(Exception e){
            System.out.printf("LoginController: error opening application window : %s\n",e.getMessage());
        }
    }
}
