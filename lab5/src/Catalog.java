
import java.util.*;
import java.io.*;
public class Catalog implements Serializable{
 private String name;
 private String path;
 private List<Document> documents = new ArrayList<>();
 public void add(Document doc) {
 documents.add(doc);
 }
 public Document findById(String id) {
	 for(Document doc : documents) { 
		   if(doc.getId().equals(id)) { 
		      return doc;
		   }
		}
	 return null;
 }
public Catalog(){}
public Catalog(String name1,String path1) {
	super();
	name=name1;
	path=path1;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Document> getDocuments() {
	return documents;
}
}
