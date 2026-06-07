package ucsal.edu.br.tutorial.hello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello_scr/hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        Stage primaryStage = new Stage();
        Scene scene = new Scene(new StackPane(),800,600);
        stage.setScene(scene);

        stage.setOnShown(event -> {
            System.out.println("Antes: " + stage.getX() + ", " + stage.getY());

            stage.centerOnScreen();

            System.out.println("Depois: " + stage.getX() + ", " + stage.getY());

            System.out.println("X: " + stage.getX());
            System.out.println("Y: " + stage.getY());
            System.out.println("Width: " + stage.getWidth());
            System.out.println("Height: " + stage.getHeight());
        });


        stage.show();

        for (Screen screen : Screen.getScreens()) {
            Rectangle2D bounds = screen.getBounds();

            System.out.println(
                    "Monitor: x=" + bounds.getMinX()
                            + " y=" + bounds.getMinY()
                            + " width=" + bounds.getWidth()
                            + " height=" + bounds.getHeight()
            );
        }

    }
}
