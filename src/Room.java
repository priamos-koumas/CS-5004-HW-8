import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * The Room class represents the location of the player's avatar. It is the central hub for any
 * interactable elements in the game including items, fixtures, puzzles, and monsters.
 */
public class Room {
  private Game game;
  private boolean gameSet;

  // The @SerializedName tag specifies if the variable name does not match the corresponding
  // key name in a JSON file and gives the correct key name (for this "room_name" is the JSON key
  // name)
  @SerializedName("room_name")
  private final String NAME;

  @SerializedName("room_number")
  private final int NUMBER;

  @SerializedName("description")
  private final String DESCRIPTION;
  private final RoomNeighbors NEIGHBORS;
  private boolean puzzle;
  private boolean monster;
  private Map<String, String> items;
  private Map<String, String> fixtures;
  private final String PICTURE;

  /**
   * Room's overloaded constructor takes in all the necessary elements that make up the Room
   * as specified below.
   *
   * @param roomName the name of the room
   * @param roomNumber the room number
   * @param description a String description of the room
   * @param n room number of room to the north
   * @param s room number of room to the south
   * @param e room number of room to the east
   * @param w room number of room to the west
   * @param puzzle the puzzle in the room
   * @param monster the puzzle in the room
   * @param items the items in the room
   * @param fixtures the fixtures in the room
   * @param picture image that depicts the room
   */
  public Room(String roomName, int roomNumber, String description,
              int n, int s, int e, int w, boolean puzzle,
              boolean monster, Map<String, String> items, Map<String, String> fixtures,
              String picture) {
    this.NAME = roomName;
    this.NUMBER = roomNumber;
    this.DESCRIPTION = description;
    int [] directions = {n, s, e, w};
    this.NEIGHBORS = new RoomNeighbors(game.getRoom(Math.abs(n)), game.getRoom(s),
                                        game.getRoom(e), game.getRoom(w));
    this.puzzle = puzzle; // ADD ERROR FOR SIMULTANEOUS PUZZLE AND MONSTER
    this.monster = monster;
    this.items = new HashMap<>();
    this.fixtures = new HashMap<>();
    this.PICTURE = picture;
    this.gameSet = false;
  }

  /**
   * Returns room name.
   *
   * @return room name
   */
  public String getRoomName() {
    return NAME;
  }

  /**
   * Returns room number.
   *
   * @return room number
   */
  public int getRoomNumber() {
    return NUMBER;
  }

  /**
   * Returns description of room.
   *
   * @return room description
   */
  public String getDescription() {
    return this.DESCRIPTION;
  }

  /**
   * Returns the room at the given CardinalDirection relative to the current Room instance.
   *
   * @param direction CardinalDirection of target room
   * @return target room
   */
  public Room getNeighbor(CardinalDirection direction) {
    return NEIGHBORS.getRoom(direction);
  }

  public void setGame(Game game) {
    if (!gameSet) {
      this.game = game;
    }
    else {
      throw new IllegalArgumentException("Game is already set");
    }
  }

  @Override
  public String toString() {
    return "Room{" +
            "game=" + game +
            ", NAME='" + NAME + '\'' +
            ", NUMBER=" + NUMBER +
            ", DESCRIPTION='" + DESCRIPTION + '\'' +
            ", NEIGHBORS=" + NEIGHBORS +
            ", puzzle=" + puzzle +
            ", monster=" + monster +
            ", items=" + items +
            ", fixtures=" + fixtures +
            ", PICTURE='" + PICTURE + '\'' +
            '}';
  }
}