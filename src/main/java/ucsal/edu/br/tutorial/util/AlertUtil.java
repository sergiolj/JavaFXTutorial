package ucsal.edu.br.tutorial.util;

import javafx.scene.control.Alert;

import java.util.Objects;

public class AlertUtil {

    public static void showWarning(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void showConfirmation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    private static void applyCustomCSS(Alert alert) {
        String css = Objects.requireNonNull(AlertUtil.class.getResource("/styles/custom_atlanta_fx.css")).toExternalForm();
        alert.getDialogPane().getStylesheets().add(css);
    }
}
