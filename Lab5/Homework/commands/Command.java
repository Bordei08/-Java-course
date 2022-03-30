package homework.commands;

import java.io.IOException;
import java.util.Scanner;
import freemarker.template.TemplateException;

import homework.catalog.*;
import homework.exceptions.*;
//import org.apache.tika.exception.TikaException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

public abstract class Command {

    public abstract void execute(Catalog catalog, Scanner scanner) throws IOException, InvalidCatalogPath, InvalidPathException, InvalidAuthorException, InvalidYearException, TemplateException, InvalidItemCatalogException, InvalidType2Exception, InvalidAtricleException, SAXException, TikaException;

    public abstract String getCommandName();
}
