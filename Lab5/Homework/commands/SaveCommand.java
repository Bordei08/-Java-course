package homework.commands;

import freemarker.template.TemplateException;
import homework.catalog.Catalog;
import homework.catalog.CatalogUtil;
import homework.exceptions.*;

import java.io.IOException;
import java.util.Scanner;

public class SaveCommand extends  Command {
    @Override
    public void execute(Catalog catalog, Scanner scanner) throws IOException, InvalidCatalogPath, InvalidPathException, InvalidAuthorException, InvalidYearException, TemplateException, InvalidItemCatalogException, InvalidType2Exception {
        CatalogUtil.save(catalog.getPath(), catalog);
    }

    @Override
    public String getCommandName() {
        return "Save";
    }
}
