package homework.exceptions;

public class InvalidPathException extends Exception{
    public InvalidPathException(String path){super("This path doesn't exists."+path);}

}
