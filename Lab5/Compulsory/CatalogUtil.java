package compulsory;


import com.fasterxml.jackson.databind.ObjectMapper;


import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {


    public static void save(String path,Catalog catalog) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);

    }



    public static Catalog load(String path) throws  IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File file=new File(path);
        return objectMapper.readValue(file, Catalog.class);
    }



    public static void view(Item item) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(item.getLocation()));

    }


}
