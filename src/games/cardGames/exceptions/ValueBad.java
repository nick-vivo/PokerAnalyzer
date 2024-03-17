package cardGames.exceptions;

public class ValueBad extends Exception {

    public ValueBad(String message) {
        super(message);
    }

    public String what() {
        return "Значение не подходит: " + super.getMessage();
    }

    @Override
    public String toString() {
        return "Значение не подходит: " + super.getMessage();
    }
}