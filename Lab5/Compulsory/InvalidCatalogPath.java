package compulsory;



public class InvalidCatalogPath  extends Exception {
    public InvalidCatalogPath(Exception ex){
        super("Invalid Catalog file or path."+ex);
    }
}