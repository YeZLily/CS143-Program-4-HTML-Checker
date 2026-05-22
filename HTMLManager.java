import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html) { 
    if(html == null) {
      throw new IllegalArgumentException();
    }
    tags = new LinkedList<HTMLTags>();
    for(HTMLTags: html) {
      tags.add(tag);  
  }

  public Queue<HTMLTag> getTags() {
    return tags;
  }
  
  public void fixHTML() {
   Stack<String> stor = new Stack<>();
   
   for(HTMLTag tag: tags) {
      
      if(tags.isOpening()) {
         stor.push(tag);      
   }
   
  }
    
}
