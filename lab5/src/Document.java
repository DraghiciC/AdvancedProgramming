import java.util.*;
import java.io.*;
public class Document implements Serializable{
 private String id;
 private String name;
 private String location; //file name or Web page

 private Map<String, Object> tags = new HashMap<>();
 //…
 public void addTag(String key, Object obj) {
 tags.put(key, obj);
 }
//…
public Document(String id1,String name1,String location1) {
	super();
	id=id1;
	name=name1;
	location=location1;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Map<String, Object> getTags() {
	return tags;
}
}