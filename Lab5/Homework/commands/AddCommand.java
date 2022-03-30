package homework.commands;


import freemarker.template.TemplateException;
import homework.catalog.*;
import homework.exceptions.*;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Scanner;


public class AddCommand extends Command {


    @Override
    public void execute(Catalog catalog, Scanner scanner) throws IOException, InvalidCatalogPath, InvalidPathException, InvalidAuthorException, InvalidYearException, TemplateException, InvalidItemCatalogException, InvalidType2Exception {
        String type, name, path, author;
        int year, id;


        type = scanner.next();

        if (!type.equals("Book") && !type.equals("Article"))
            throw new InvalidType2Exception(type);

        name = scanner.next();

        path = scanner.next();



        author = scanner.next();
        if (author == null || author.trim().equals("") || (!author.matches("[a-zA-Z]+"))) {
            throw new InvalidAuthorException(author);
        }


        year = Integer.parseInt(scanner.next());
        if (year > Calendar.getInstance().get(Calendar.YEAR) || year <= 0) {
            throw new InvalidYearException(year);
        }


        id = Integer.parseInt(scanner.next());

      Item item;

        if(type.equals("Book"))
            item = new Book("Book",Integer.toString(id),name,path,Integer.toString(year),author);
        else
            item = new Article("Article",Integer.toString(id),name,path,Integer.toString(year),author);

       catalog.add(item);
    }


    public String getCommandName() {
        return "Add";
    }


}
