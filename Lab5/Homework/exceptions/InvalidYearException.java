package homework.exceptions;

public class InvalidYearException extends Exception{
    public InvalidYearException(int year){super("This year is not correct."+year);}
}
