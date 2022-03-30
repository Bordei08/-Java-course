package homework;

import freemarker.template.TemplateException;
import homework.catalog.Catalog;
import homework.*;
import homework.catalog.CatalogUtil;
import homework.commands.*;
import homework.exceptions.*;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidType2Exception, TemplateException, InvalidYearException, IOException, InvalidItemCatalogException, InvalidPathException, InvalidCatalogPath, InvalidAuthorException, TikaException, InvalidAtricleException, SAXException {
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog("Catalog", "D:\\cataalog.json");
        AddCommand add = new AddCommand();
        add.execute(catalog,scanner);
        add.execute(catalog,scanner);
        add.execute(catalog,scanner);
        add.execute(catalog,scanner);
        ListCommand list = new ListCommand();
        list.execute(catalog,scanner);
        ViewCommand view = new ViewCommand();
        view.execute(catalog,scanner);
        ReportCommand report = new ReportCommand();
        report.execute(catalog,scanner);
        SaveCommand save = new SaveCommand();
        save.execute(catalog,scanner);
        LoadCommand load = new LoadCommand();
        load.execute(catalog,scanner);
        InfoCommand info = new InfoCommand();
        info.execute(catalog,scanner);

    }
}
