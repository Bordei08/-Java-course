package homework.commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import homework.catalog.Catalog;
import homework.exceptions.*;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Aceasta clasa implementeaza un obiect care va creea un raport HTML al obiectului catalog
 * Initial vom configura locatia fisierului si vom seta un template pentru acesta, template ul pentru raportul html este in fisierul item.ftl
 * Apoi vom face o mapare conform template ului dat
 * Dupa ce am creat fiserul il voi deschide in browser ul nativ
 */

public class ReportCommand extends  Command{
    @Override
    public void execute(Catalog catalog, Scanner scanner) throws IOException, InvalidCatalogPath, InvalidPathException, InvalidAuthorException, InvalidYearException, TemplateException, InvalidItemCatalogException, InvalidType2Exception {
        Configuration cfg = new Configuration(new Version("2.3.23"));
        cfg.setDirectoryForTemplateLoading(new File("D:\\"));
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        Template template = cfg.getTemplate("items.ftl");
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("title", "Items from my catalog");
        templateData.put("catalogName", catalog.getName());
        templateData.put("catalogPath", catalog.getPath());
        templateData.put("items", catalog.getItems());

        Writer file = new FileWriter("D:\\Report\\reportcatalog.html");
        template.process(templateData, file);
        file.flush();
        file.close();

        Path path = Paths.get("D:\\reportcatalog.html");

        Desktop desktop = Desktop.getDesktop();

        desktop.open(path.toFile());
    }

    @Override
    public String getCommandName() {
        return "Report";
    }
}
