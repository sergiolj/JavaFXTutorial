module ucsal.edu.br.runner.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.desktop;

    exports ucsal.edu.br.runner.javafx.model;
    opens ucsal.edu.br.runner.javafx.model to javafx.fxml;

    exports ucsal.edu.br.runner.javafx.util;
    opens ucsal.edu.br.runner.javafx.util to javafx.fxml;


    exports ucsal.edu.br.runner.javafx;
    opens ucsal.edu.br.runner.javafx to javafx.fxml;

    exports ucsal.edu.br.runner.javafx.controller;
    opens ucsal.edu.br.runner.javafx.controller to javafx.fxml;
    exports ucsal.edu.br.runner.javafx.navigation;
    opens ucsal.edu.br.runner.javafx.navigation to javafx.fxml;
}