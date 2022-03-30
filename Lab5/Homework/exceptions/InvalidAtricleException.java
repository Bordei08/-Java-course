package homework.exceptions;

public class InvalidAtricleException extends Exception {
    public InvalidAtricleException(String name) {
        super("This item not is Atricle." + name);
    }
}
