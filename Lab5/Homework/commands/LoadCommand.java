package homework.commands;


import homework.catalog.*;
import freemarker.template.TemplateException;
import homework.catalog.Catalog;

import homework.exceptions.*;

import java.io.IOException;
import java.util.Scanner;

public class LoadCommand extends Command {
    @Override
    public void execute(Catalog catalog, Scanner scanner) throws IOException, InvalidCatalogPath, InvalidPathException, InvalidAuthorException, InvalidYearException, TemplateException, InvalidItemCatalogException, InvalidType2Exception {
        catalog = CatalogUtil.load(catalog.getPath());
    }

    @Override
    public String getCommandName() {
        return "Load";
    }
}
