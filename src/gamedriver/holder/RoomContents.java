package gamedriver.holder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gamedriver.elements.IElements;

public class RoomContents {
  public Map<String, IElements> contents;
  //Should this be IItem or IRoomContents

  public RoomContents() {
    contents = new HashMap<String, IElements>();
  }


  public void removeItem(String name) {
    contents.remove(name);
  }

  public List<IElements> getItem() {
    List<IElements> contentsList = new ArrayList<>(contents.values());
    return contentsList;
  }

  public String toString() {
    String result = "";

    for (IElements exist: this.getItem()) {
      result = result + "\nName: " + exist.getName()
              + "\nDescription: " + exist.getDescription();
    }

    result += "\n";

    return result;
  }

}
