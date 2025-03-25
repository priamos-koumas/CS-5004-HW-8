import java.util.HashMap;
import java.util.List;

/**
 * The room obstacles class manages the passing of key information about any relevant
 * puzzles or enemies to the Room class upon instantiation. Examples of information passing
 * include creation, removal, checks on whether an obstacle has been cleared during the game play.
 */
public class RoomObstacles implements IHolder {

  private HashMap<String, IObstacle> obstacles;
  private IObstacle iObstacle;

  public RoomObstacles() {
    this.obstacles = new HashMap<>();
  }

  public void addObstacle(String s, IObstacle o) {
    this.obstacles.put(s, o);
  }

  public IObstacle getObstacle(String s) {
    return this.obstacles.get(s);
  }


  /**
   * Check if the bag have enough storage.
   * if true add the item in to the storage list.
   *
   * @param item
   */
  @Override
  public boolean addItem(IItem item) {
    return false;
  }

  /**
   * Check if the item is in the holder.
   * if true remove and return the item.
   *
   * @param name
   */
  @Override
  public void removeItem(String name) {

  }

  /**
   * Check if the item is in the holder.
   *
   * @return Item object
   */
  @Override
  public <T> List<T> getItem() {
    return List.of();
  }

  /**
   * set weight limit.
   *
   * @param limit
   */
  @Override
  public void setWeightLimit(int limit) {

  }

  @Override
  public String toString() {
    return "";
  }
}
