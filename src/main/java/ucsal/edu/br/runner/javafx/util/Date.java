package ucsal.edu.br.runner.javafx.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 *
 * @author Sérgio Lopes Júnior
 *
 * @version 1.0
 */
public class Date {

    public static String format(LocalDate date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(df);
    }
}
