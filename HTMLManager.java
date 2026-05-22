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
   Stack<HTMLTag> stor = new Stack<HTMLTag>();
   
   for(HTMLTag tag: tags) {
      
      if(tag.isOpening()) {
         stor.push(tag);
         tags.add(tag);      
      }
      
      else if(tag.isClosing()) {
         if(tag.matches()) {
            stor.push(tag);
            tags.add(tag);
         }
         
        }
         else if(!tag.matches()) {
            stor.push(tags.getMatching(tag));
            tags.remove(tag);
            tags.add(tag);
         }
   }
   
  }
    
}
