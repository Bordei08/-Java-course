package homework.commands;

import freemarker.template.TemplateException;
import homework.catalog.Catalog;
import homework.catalog.Item;
import homework.exceptions.*;

import java.io.IOException;
import java.util.Scanner;


/**
 * Aceasta clasa implementeaza doua metode :
 * execute , care va afisa elementele din catalogul primit ca parametru
 * getCommandName, numele comenzii
 */

public class ListCommand extends Command {

    @Override
    public void execute(Catalog catalog, Scanner scanner) throws IOException, InvalidCatalogPath, InvalidPathException, InvalidAuthorException, InvalidYearException, TemplateException, InvalidItemCatalogException, InvalidType2Exception {
        String result = "";
        for(Item idx : catalog.getItems())
            result += idx.toString() + "\n";

        System.out.println(result);
    }

    @Override
    public String getCommandName() {
        return "List";
    }
}
