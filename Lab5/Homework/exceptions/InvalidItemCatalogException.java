package homework.exceptions;

public class InvalidItemCatalogException extends Exception {
    public InvalidItemCatalogException(String name){super("This item is not in the catalog."+name);}
}