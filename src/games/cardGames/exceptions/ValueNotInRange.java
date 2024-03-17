package cardGames.exceptions;

import java.lang.Exception;

public class ValueNotInRange extends Exception {

    public ValueNotInRange(String message) {
        super(message);
    }

    public String what() {
        return "Значение не лежит в указанном промежутке: " + super.getMessage();
    }

    @Override
    public String toString() {
        return "Значение не лежит в указанном промежутке: " + super.getMessage();
    }
}