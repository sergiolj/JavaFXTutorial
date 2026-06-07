package ucsal.edu.br.runner.javafx.util;

import atlantafx.base.theme.*;
import javafx.application.Application;
/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
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
