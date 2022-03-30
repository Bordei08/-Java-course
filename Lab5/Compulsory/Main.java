package compulsory;

import java.io.IOException;

public class Main  implements  java.io.Serializable{
    public static void main(String[] args) throws IOException, InvalidCatalogPath {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyRefs");
        Item book = new Book("book", "The Art of Computer Programming", "d:/books/programming/tacp.ps","1967", "Donald E. Knuth");
        Item article = new Article("article1", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html","2021", "James Gosling & others");
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save("d:/research/catalog.json",catalog);
       // System.out.println(catalog.toString());
    }

    private void testLoadView() throws InvalidCatalogPath, IOException {
        Catalog catalog = CatalogUtil.load("d:/research/catalog.json");

        // System.out.println(catalog);
        CatalogUtil.view(catalog.findById("article1"));
    }

}
