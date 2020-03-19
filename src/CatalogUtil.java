import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.io.*;
import java.awt.*;
public class CatalogUtil {
 public static void save(Catalog catalog)
 throws IOException {
 try (ObjectOutputStream oos = new ObjectOutputStream(
 new FileOutputStream( catalog.getPath() ))) {
 oos.writeObject(catalog);
 }
 catch (IOException e) {
 System.out.println("Unexpected error reading the file!");
 e.printStackTrace();
 }
 }
 
 public static Catalog load(String path)
 throws InvalidCatalogException {

 Catalog catalog = new Catalog();
 try (ObjectInputStream ois = new ObjectInputStream(
         new FileInputStream(new File(path)))) {
     catalog = (Catalog) ois.readObject();
 } catch (FileNotFoundException e) {
     throw new InvalidCatalogException(e);

 } catch (IOException e) {
     throw new InvalidCatalogException(e);

 } catch (ClassNotFoundException e) {
     throw new InvalidCatalogException(e);
 }
 return catalog;
 }
 
 public static void view(Document doc) throws URISyntaxException, IOException {
     Desktop desktop = Desktop.getDesktop();
     //… browse or open, depending of the location type

     if(doc.getLocation().startsWith("http")){
         URI webpage = new URI(doc.getLocation());
         desktop.browse(webpage);
     }else {
         File file = new File(doc.getLocation());
         desktop.open(file);
     }
 }
} 