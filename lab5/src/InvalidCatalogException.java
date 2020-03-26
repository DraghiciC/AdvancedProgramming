import java.util.*;
public class InvalidCatalogException extends Exception {
 public InvalidCatalogException(Exception ex) {
 super("Can't load. Invalid catalog file.", ex);
 }
}

