module ucsal.edu.br.tutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.desktop;


    exports ucsal.edu.br.tutorial;
    opens ucsal.edu.br.tutorial to javafx.fxml;

    exports ucsal.edu.br.tutorial.login;
    opens ucsal.edu.br.tutorial.login to javafx.fxml;
    exports ucsal.edu.br.tutorial.hello;
    opens ucsal.edu.br.tutorial.hello to javafx.fxml;
    exports ucsal.edu.br.tutorial.showcase;
    opens ucsal.edu.br.tutorial.showcase to javafx.fxml;
}