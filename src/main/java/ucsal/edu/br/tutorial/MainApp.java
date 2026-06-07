package ucsal.edu.br.tutorial;

import javafx.application.Application;

import javafx.stage.Stage;
import ucsal.edu.br.tutorial.util.SceneManager;
import ucsal.edu.br.tutorial.util.Themes;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Themes.PRIME_DARK.applyTheme();
        SceneManager.setStage(primaryStage);
        SceneManager.loadLogin();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
