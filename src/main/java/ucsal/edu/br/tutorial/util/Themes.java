package ucsal.edu.br.tutorial.util;

import atlantafx.base.theme.*;
import javafx.application.Application;

public enum Themes {
    PRIME_DARK(new PrimerDark()),
    PRIMER_LIGHT(new PrimerLight()),
    CUPERTINO_LIGHT(new CupertinoLight()),
    CUPERTINO_DARK(new CupertinoDark());

    private final Theme theme;

    Themes(Theme theme) {
        this.theme = theme;
    }

    public void applyTheme() {
        Application.setUserAgentStylesheet(this.theme.getUserAgentStylesheet());
    }
}
