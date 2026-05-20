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
  
}
