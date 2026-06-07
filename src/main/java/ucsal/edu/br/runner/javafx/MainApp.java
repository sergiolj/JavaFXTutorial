package ucsal.edu.br.runner.javafx;

import javafx.application.Application;

import javafx.stage.Stage;
import ucsal.edu.br.runner.javafx.navigation.SceneManager;
import ucsal.edu.br.runner.javafx.util.Themes;

/**
 * Classe Main
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Themes.PRIME_DARK.applyTheme();
        SceneManager.setStage(primaryStage); //Passa o stage criado pelo start do JavaFX para o gerenciador
        SceneManager.loadLogin(); // O gerenciador carrega a primeira Scene
    }

    public static void main(String[] args) {
        launch(args);
    }
}
