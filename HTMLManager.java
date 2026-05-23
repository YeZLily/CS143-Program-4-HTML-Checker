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
   
   while(!tags.isEmpty()) {
         HTMLTag tag = tags.remove();
         
         if(tag.isSelfClosing()) {
            fixed.add(tag);  
         } 
         
         else if(tag.isOpening()) {
            stor.push(tag);
            fixed.add(tag);
         
         }
          
         else if(tag.isClosing()) {
              if (stor.isEmpty()) {
              
              } 
              else if(tag.matches(stor.peek())) {
                  fixed.add(tag);
                  stor.pop();
                  
              } 
              else {
                  while (!stor.isEmpty() && !tag.matches(stor.peek())) {
                    fixed.add(stor.pop().getMatching());
                  }
                  
                  if (!stor.isEmpty()) {
                     fixed.add(tag);
                     stor.pop();
                 }
              }
           }
       }
       while (!stor.isEmpty()) {
        fixed.add(stor.pop().getMatching());
       }
       tags = fixed;
    }
}



