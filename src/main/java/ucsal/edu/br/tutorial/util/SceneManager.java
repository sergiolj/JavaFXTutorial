package ucsal.edu.br.tutorial.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class SceneManager {
    private static Stage stage;

    /**
     * O Stage principal é criado no MainApp automaticamente pelo JavaFX e inicializado pelo start(Stage primaryStage)
     * Em seguida esse stage usa o método estático da SceneManager para determinar o atributo stage que será
     * usado durante todo o funcionamento do app.
     * @param primaryStage
     */
    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void load(String fxml, String title, double width, double height){
        try{
            if(stage == null){
                throw new IllegalStateException("Stage principal não foi configurado corretamente no SceneManager. Verifique" +
                        "o uso do SceneManager.setStage(Stage stage) no MainApp. ");
            }
            URL fxmlURL = SceneManager.class.getResource(fxml);
            if(fxmlURL == null){
                throw new IllegalArgumentException("Arquivo Fxml não encontrado em: " + fxml);
            }

            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneManager.class.getResource(fxml)));

            stage.setScene(new Scene(root, width, height));
            stage.setTitle(title);
            stage.centerOnScreen();
            stage.show();
        }catch(Exception e){
            System.out.printf("SceneManager: error opening FXML file : %s%s\n", fxml, e.getMessage());
            throw  new RuntimeException(e);
        }
    }

    public static void loadLogin() {
        String fxml = "/login_scr/login_view.fxml";
        String title = "Login";
        double width = 400;
        double height = 280;
        load(fxml, title, width, height);
    }

    public static void loadEventCreator() {
        String fxml = "/showcase_scr/event_creator.fxml";
        String  title = "Event Creator";
        double width = 700;
        double height = 800;

        load(fxml,title,width,height);
        onCloseReturnMain(); //Caso o usuário feche a janela o app retorna a janela main.
    }

    public static void loadMain() {
        String fxml = "/showcase_scr/main_view.fxml";
        String  title = "Main View";
        double width = 700;
        double height = 800;
        load(fxml,title,width,height);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void onCloseReturnMain() {
        stage.setOnCloseRequest(event -> {
            event.consume();
            loadMain();
        });
    }
}
