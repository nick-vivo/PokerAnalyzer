package cardGames.exceptions;

import java.lang.Exception;

public class SizeExceeded extends Exception {

    public SizeExceeded(String message) {
        super(message);
    }

    public String what() {
        return "Допустимый размер превышен: " + super.getMessage();
    }

    @Override
    public String toString() {
        return "Допустимый размер превышен: " + super.getMessage();
    }

}