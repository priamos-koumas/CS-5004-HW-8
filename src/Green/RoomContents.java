package Green;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomContents implements IHolder {
  public Map<String, IItem> contents;
  //Should this be IItem or IRoomContents

  public RoomContents() {
    contents = new HashMap<String, IItem>();
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
