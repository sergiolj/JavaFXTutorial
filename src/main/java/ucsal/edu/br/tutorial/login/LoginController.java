package ucsal.edu.br.tutorial.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ucsal.edu.br.tutorial.MainApp;
import ucsal.edu.br.tutorial.util.AlertUtil;
import ucsal.edu.br.tutorial.util.SceneManager;

public class LoginController {
    @FXML
    public Label lb_login_msg;
    @FXML
    private BorderPane bd_pane;
    @FXML
    private TextField tf_login_name, tf_password;

    @FXML
    private Button btn_login, btn_exit;

    @FXML
    public void initialize(){
        btn_login.setOnAction(event -> {
                    String login_name = tf_login_name.getText();
                    String password = tf_password.getText();
                    if (login_name.equalsIgnoreCase("") && password.equals("") ){
                        openApplication();
                    } else {
                        AlertUtil.showError("Login Failed", "Login Failed, name or password is incorrect.");
                    }
                });

//        btn_logout.setOnAction(event ->{
//            AlertUtil.showConfirmation( "Logout", "User " + tf_login_name.getText() + " logout successfully");
//                tf_login_name.clear();
//                tf_password.clear();
//                lb_login_msg.setVisible(false);
//        });

        btn_exit.setOnAction(event ->{
            Stage currentWindow = (Stage) btn_exit.getScene().getWindow();
            currentWindow.close();
        });
    }

    private void openApplication() {
        try{
            SceneManager.loadMain();
        }catch(Exception e){
            System.out.printf("LoginController: error opening application window : %s\n",e.getMessage());
        }
    }
}
