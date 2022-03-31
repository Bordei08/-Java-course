package homework.catalog;




import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {


    /**
     * Aceasta metoda salveaza un obiect de tip Catalog intr-un fisier Json la o anumita cale
     * Fiserul Json trebuie sa fie deja creat, acesta find data si in cale
     * @param path
     * @param catalog
     * @throws IOException
     */

    public static void save(String path, Catalog catalog) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);

    }

    /**
     * Aceasta metoda returneaza un catalog obtinut din citire unui fisier cu format Json.
     * Calea carte acest fisier este data ca parametru
     * @param path
     * @return
     * @throws IOException
     */
    public static Catalog load(String path) throws  IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File file=new File(path);
        return objectMapper.readValue(file, Catalog.class);
    }


    /**
     * Aceasta metoda primeste un item si va deschide path-ul sau in browser-ul nativ
     * @param item
     * @throws IOException
     */

    public static void view(Item item) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(item.getLocation()));

    }


}
