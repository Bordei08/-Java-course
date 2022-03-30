package homework.exceptions;

public class InvalidType2Exception extends Exception{
    public InvalidType2Exception(String name){super("Type of the item is not correct."+name);
    }
}

