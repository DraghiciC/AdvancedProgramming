import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InvalidCatalogException, IOException, URISyntaxException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "D:\\catalog.ser");

        Document document1 = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document1.addTag("type", "Slides");
        catalog.add(document1);
        Document document2 = new Document("text1", "Java text 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/Java_text.txt"); //un fisier local din D:\
        document2.addTag("type", "Text");
        catalog.add(document2);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, URISyntaxException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Dan\\Desktop\\AdvancedProgramming");
        Document document1 = catalog.findById("java1");
        Document document2 = catalog.findById("text1");
        CatalogUtil.view(document1);
        CatalogUtil.view(document2);
    }
}