package homework.commands;

import freemarker.template.TemplateException;
import homework.catalog.Catalog;
import homework.exceptions.*;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Scanner;

public class InfoCommand extends Command {
    @Override
    public void execute(Catalog catalog, Scanner scanner) throws IOException, InvalidCatalogPath, InvalidPathException, InvalidAuthorException, InvalidYearException, TemplateException, InvalidItemCatalogException, InvalidType2Exception, InvalidAuthorException, InvalidAtricleException, SAXException, TikaException {
            String id = scanner.next();
           MetadataItem metadata = new MetadataItem();
           metadata.getMetadata(catalog.findById(id).getLocation());


    }

    @Override
    public String getCommandName() {
        return "info";
    }
}
