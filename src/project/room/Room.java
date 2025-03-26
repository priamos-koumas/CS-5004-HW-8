package project.room;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

import project.elements.IElements;
import project.game.Game;
import project.game.RoomData;
import project.holder.Bag;
import project.holder.IHolder;
import project.holder.RoomContents;
import project.obstacle.IObstacle;

/**
 * The room.Room class represents the location of the player's avatar. It is the central hub for any
 * interactable elements in the game including roomItems, roomFixtures, puzzles, and monsters.
 */
public class Room {
  private Game game;

  // The @SerializedName tag specifies if the variable name does not match the corresponding
  // key name in a JSON file and gives the correct key name (for this "room_name" is the JSON key
  // name)
  @SerializedName("room_name")
  private final String NAME;

  @SerializedName("room_number")
  private final int NUMBER;

  @SerializedName("description")
  private final String DESCRIPTION;
  private int[] directions;
  private RoomNeighbors neighbors;
  private IObstacle obstacle;
  private IHolder<IElements> roomItems;
  private IHolder<IElements> roomFixtures;
  private final String PICTURE;

  /**
   * room.Room's overloaded constructor takes in all the necessary elements that make up the room.Room
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
   * @param items the roomItems in the room
   * @param fixtures the roomFixtures in the room
   * @param picture image that depicts the room
   */
  public Room(String roomName, int roomNumber, String description,
              int n, int s, int e, int w, String puzzle,
              String monster, String items, String fixtures,
              String picture) {
    this.NAME = roomName;
    this.NUMBER = roomNumber;
    this.DESCRIPTION = description;
    int [] directions = {n, s, e, w};
    this.neighbors = new RoomNeighbors(this.game.getRooms());
    setObstacle(monster, puzzle);
    this.roomItems = new Bag(13);
    setRoomItems(items);
    this.roomFixtures = new RoomContents();
    setRoomFixtures(fixtures);
    this.PICTURE = picture;
  }

  public Room(Game game, RoomData data) {
    this.game = game;
    this.NAME = data.getRoomName();
    this.NUMBER = Integer.parseInt(data.getRoomNumber());

    this.DESCRIPTION = data.getDescription();
    int[] directions = {data.getN(), data.getS(), data.getE(), data.getW()};
    this.directions = directions;
    this.PICTURE = data.getPicture();
    setObstacle(data.getMonster(), data.getPuzzle());
    this.roomItems = new RoomContents();
    setRoomItems(data.getItems());
    this.roomFixtures = new RoomContents();
    setRoomFixtures(data.getFixtures());
  }

  public void createNeighbors(List<Room> rooms) {
    this.neighbors = new RoomNeighbors(rooms);
    setNeighbors(this.directions);
  }

  /**
   * Sets the Neighbors attribute from JSON class. The order of the numbers in the  directions
   * array must be n, s, e, w.
   *
   * @param directions array of room numbers
   */
  private void setNeighbors(int[] directions) {
    this.neighbors.setNeighbor(CardinalDirection.NORTH, directions[0]);
    this.neighbors.setNeighbor(CardinalDirection.SOUTH, directions[1]);
    this.neighbors.setNeighbor(CardinalDirection.EAST, directions[2]);
    this.neighbors.setNeighbor(CardinalDirection.WEST, directions[3]);
  }

  /**
   * Processes a String of Item names (format: 'item1, item2, etc') and adds the corresponding
   * Item object to the roomItems attribute.
   *
   * @param roomItems String of Item names
   */
  private void setRoomItems(String roomItems) {
    if (roomItems != null) {
      List<String> itemsList = Arrays.asList(roomItems.split("\\s*,\\s*"));
      for (String item : itemsList) {
        for (IElements i : this.game.getItems()) {
          if (i.getName().equals(item)) {
            this.roomItems.addItem(i);
          }
        }
      }
    }
  }

  /**
   * Processes a String of Fixture names (format: 'fixture1, fixture2, etc') and adds the
   * corresponding Fixture object to the roomFixtures attribute.
   *
   * @param roomFixtures String of Fixture names
   */
  private void setRoomFixtures(String roomFixtures) {
    if (roomFixtures != null) {
      List<String> fixturesList = Arrays.asList(roomFixtures.split("\\s*,\\s*"));
      for (String fixture : fixturesList) {
        for (IElements i : this.game.getFixtures()) {
          if (i.getName().equals(fixture)) {
            this.roomFixtures.addItem(i);
          }
        }
      }
    }
  }

  /**
   * Sets the obstacle parameter and ensures that there is no more than one enemy XOR one puzzle.
   *
   * @param enemy name of Enemy
   * @param puzzle name of Puzzle
   */
  private void setObstacle(String enemy, String puzzle) {

    if (enemy == null && puzzle == null) {
      this.obstacle = null;
    } else if (puzzle == null) {
      this.obstacle = game.getMonster(enemy);
    } else if (enemy == null) {
      this.obstacle = game.getPuzzle(puzzle);
    } else {
      throw new IllegalArgumentException(
              "Only one enemy or one puzzle may be included, not both"
      );
    }
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
   * Returns the room at the given room.CardinalDirection relative to the current room.Room instance.
   *
   * @param direction room.CardinalDirection of target room
   * @return target room
   */
  public Room getNeighbor(CardinalDirection direction) {
    return neighbors.getRoom(direction);
  }

  @Override
  public String toString() {
    return "room.Room{" +
            ", NAME='" + NAME + '\'' +
            ", NUMBER=" + NUMBER +
            ", DESCRIPTION='" + DESCRIPTION + '\'' +
            ", neighbors=" + neighbors +
            ", obstacle=" + obstacle +
            ", roomItems=" + roomItems +
            ", roomFixtures=" + roomFixtures +
            ", PICTURE='" + PICTURE + '\'' +
            '}' + "\n";
  }

  public IHolder<IElements> getRoomItems() {
    return this.roomItems;
  }

  public List<IElements> getRoomItemsList() {
    return this.roomItems.getItem();
  }
}