package cardGames.exceptions;

import java.lang.Exception;

public class ValueTooSmall extends Exception {

    public ValueTooSmall(String message) {
        super(message);
    }

    public String what() {
        return "Значение меньше нужного: " + super.getMessage();
    }

    @Override
    public String toString() {
        return "Значение меньше нужного: " + super.getMessage();
    }
}