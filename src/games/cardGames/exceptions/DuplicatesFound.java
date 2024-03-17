package cardGames.exceptions;

import java.lang.Exception;

public class DuplicatesFound extends Exception {

    public DuplicatesFound(String message) {
        super(message);
    }

    public String what() {
        return "Обнаружены дубликаты: " + super.getMessage();
    }

    @Override
    public String toString() {
        return "Обнаружены дубликаты: " + super.getMessage();
    }

}