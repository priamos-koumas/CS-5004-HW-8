package Green;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import GameEngine.IHolder;
import GameEngine.IItem;

public class RoomContents implements IHolder {
  public Map<String, IItem> contents;

  public RoomContents() {
    contents = new HashMap<>();
  }

  @Override
  public void addItem(IItem item) {
    contents.put(item.getName(), item);
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

