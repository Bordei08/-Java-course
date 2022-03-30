package homework.exceptions;

public class InvalidComandException extends Exception {
    public InvalidComandException(String command) {
        super("Command doesn't exist." + command);
    }
}