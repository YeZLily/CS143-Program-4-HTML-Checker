import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html) { 
    if(html == null) {
      throw new IllegalArgumentException();
    }
    tags = new LinkedList<HTMLTag>();
    for(HTMLTag tag: html) {
      tags.add(tag);  
    }
  }
  
  public Queue<HTMLTag> getTags() {
    return tags;
  }

  
  public String toString() {
    String result = "";
    int size = tags.size();
    for(int i = 0; i < size; i++) { 
      HTMLTag tag = tags.remove();
      result += tag.toString().trim();
      
    }
  }
  
   public void fixHTML() {
   Stack<HTMLTag> stor = new Stack<HTMLTag>();
   Queue<HTMLTag> fixed = new LinkedList<>();
   
   while(!tags.isEmpty) {
   HTMLTag tag = tags.remove();   
     if(tag.isClosing()) {
       fixed.add(tag);
     } else if(tag.isOpening()) {
       stor.push(tag);
       fixed.add(tag);
     } else if(tag.matches(stor.peek())) {
           stor.push(tag);
           tags.add(tag);
        }
        
       }
        else if(!tag.matches(stor.peek())) {
           stor.push(tag.getMatching());
           tags.remove(tag);
           tags.add(tag);
        }
  }
  
 }
     
}
  
}


