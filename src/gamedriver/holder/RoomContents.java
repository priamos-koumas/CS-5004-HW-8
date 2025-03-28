package gamedriver.holder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gamedriver.elements.IElements;

public class RoomContents implements IHolder<IElements> {
  public Map<String, IElements> contents;
  //Should this be IItem or IRoomContents

  public RoomContents() {
    contents = new HashMap<String, IElements>();
  }

  @Override
  public boolean addItem(IElements item) {
    contents.put(item.getName(), item);
    return true;
  }

  @Override
  public void removeItem(String name) {
    contents.remove(name);
  }

  @Override
  public List<IElements> getItem() {
    List<IElements> contentsList = new ArrayList<>(contents.values());
    return contentsList;
  }

  @Override
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
