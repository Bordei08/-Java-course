package homework.exceptions;

public class InvalidAuthorException extends Exception{
    public InvalidAuthorException(String name){super("Name of the author is not correct."+name);
    }
}