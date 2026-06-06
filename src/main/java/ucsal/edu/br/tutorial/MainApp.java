package ucsal.edu.br.tutorial;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import ucsal.edu.br.tutorial.util.Themes;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Themes.PRIME_DARK.applyTheme();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login_scr/login-view.fxml"));

        Scene sceneLogin = new Scene(loader.load(),400,300);
        primaryStage.setTitle("Runner - Login");
        primaryStage.setScene(sceneLogin);

        primaryStage.show(); //Monta a tela e mostra
        primaryStage.setOnShown(event -> {
            primaryStage.centerOnScreen();
        }); //Centraliza com a tela já existente
    }

    public static void main(String[] args) {
        launch(args);
    }
}
