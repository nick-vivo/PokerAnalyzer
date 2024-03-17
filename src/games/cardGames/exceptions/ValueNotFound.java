package cardGames.exceptions;

import java.lang.Exception;

public class ValueNotFound extends Exception {

    public ValueNotFound(String message) {
        super(message);
    }

    public String what() {
        return "Значение не обнаружено: " + super.getMessage();
    }

    @Override
    public String toString() {
        return "Значение не обнаружено: " + super.getMessage();
    }
}
