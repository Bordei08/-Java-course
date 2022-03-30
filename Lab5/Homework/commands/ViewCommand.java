package homework.commands;

import freemarker.template.TemplateException;
import homework.catalog.Catalog;
import homework.catalog.CatalogUtil;
import homework.exceptions.*;

import java.io.IOException;
import java.util.Scanner;

public class ViewCommand extends Command {
    @Override
    public void execute(Catalog catalog, Scanner scanner) throws IOException, InvalidCatalogPath, InvalidPathException, InvalidAuthorException, InvalidYearException, TemplateException, InvalidItemCatalogException, InvalidType2Exception {
        CatalogUtil.view(catalog.findById(scanner.next()));
    }

    @Override
    public String getCommandName() {
        return "View";
    }
}
