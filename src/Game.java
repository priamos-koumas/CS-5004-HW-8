import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Game class is used to convert the game data from a given JSON file to Java classes.
 */
public class Game {
  private String name;
  private String version;
  private List<Room> rooms;

  /**
   * Game objects are created with a name, a version number, and a List of Room objects.
   *
   * @param name name of the Game instance
   * @param version version number of the Game instance
   * @param rooms Room objects that make up the game's "map"
   */
  public Game(String name, String version, Room[] rooms) {
    this.name = name;
    this.version = version;
    this.rooms = new ArrayList<Room>(Arrays.asList(rooms));
    for (Room room : rooms) {
      room.setGame(this);
    }
  }

  /**
   * Returns a shallow copy of the Game's rooms in an ArrayList.
   *
   * @return Game's rooms
   */
  public List<Room> getRooms() {
    return new ArrayList<Room>(rooms);
  }

  /**
   * Return's a single Room instance given the room number. The index is offset because room numbers
   * are one-indexed.
   *
   * @param roomNumber desired Room instance's room number.
   *
   * @return desire Room
   */
  public Room getRoom(int roomNumber) {
    int index = roomNumber - 1;
    if (index < 0 || index >= rooms.size()) {
      throw new IndexOutOfBoundsException("Invalid room number: " + roomNumber);
    }
    return rooms.get(index);
  }

  @Override
  public String toString() {
    return "Game{" +
            "name='" + name + '\'' +
            ", version='" + version + '\'' +
            ", rooms=" + rooms +
            '}';
  }
}
