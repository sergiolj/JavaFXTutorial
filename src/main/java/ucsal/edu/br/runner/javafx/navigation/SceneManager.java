package ucsal.edu.br.runner.javafx.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
public class SceneManager {
    private static Stage stage;

    /**
     * O Stage principal é criado no MainApp automaticamente pelo JavaFX e inicializado pelo start(Stage primaryStage)
     * Em seguida esse stage usa o método estático da SceneManager para determinar o atributo stage que será
     * usado durante todo o funcionamento do app.
     * @param primaryStage é o stage principal criado pelo JavaFX na inicialização.
     */
    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    /**
     * Executa o carregamento de todas as Scenes utilizadas no app.
     * É utilizado pela classe para carregar Scenes já configuradas.
     *
     * @param fxml caminho para o arquivo fxml
     * @param title título do stage
     * @param width largura da scene
     * @param height altura da scene
     */
    private static void load(String fxml, String title, double width, double height){
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
            stage.sizeToScene();
            stage.show();
        }catch(Exception e){
            System.out.printf("SceneManager: error opening FXML file : %s%s\n", fxml, e.getMessage());
            throw  new RuntimeException(e);
        }
    }

    /**
     * Configuração para abrir a scena de login.
     */
    public static void loadLogin() {
        String fxml = "/view/login_view.fxml";
        String title = "Runner Login";
        double width = 400;
        double height = 280;
        load(fxml, title, width, height);
    }

    /**
     * Configuração para abrir a scena de principal.
     */
    public static void loadMain() {
        String fxml = "/view/main_view.fxml";
        String  title = "Runner Main View";
        double width = 700;
        double height = 800;
        load(fxml,title,width,height);
    }

    /**
     * Configuração para abrir a scena de criação de novos eventos.
     */
    public static void loadEventCreator() {
        String fxml = "/view/event_creator.fxml";
        String  title = "Runner Event Creator";
        double width = 500;
        double height = 800;

        load(fxml,title,width,height);
        onCloseReturnMain(); //Caso o usuário feche a janela o app retorna a janela main.
    }

    /**
     * Em caso de fechamento de uma janela pelo usuário abre a scena main.
     */
    public static void onCloseReturnMain() {
        stage.setOnCloseRequest(event -> {
            event.consume();
            loadMain();
        });
    }
}
