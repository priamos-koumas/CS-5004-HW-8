package project.holder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.elements.IElements;

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
  public <T> List<T> getItem() {
    return List.of();
  }

}
