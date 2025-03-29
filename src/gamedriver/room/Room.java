package gamedriver.room;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

import gamedriver.elements.IElements;
import gamedriver.game.Game;
import gamedriver.game.RoomData;
import gamedriver.holder.Bag;
import gamedriver.holder.IHolder;
import gamedriver.holder.RoomContents;
import gamedriver.obstacle.IObstacle;

/**
 * The Room class represents the location of the player's avatar. It is the central hub for any
 * interactable elements in the game including roomItems, roomFixtures, puzzles, and monsters.
 */
public class Room {
  private Game game;
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
   * @param items the roomItems in the room
   * @param fixtures the roomFixtures in the room
   * @param picture image that depicts the room
   */
  public Room(Game game, String roomName, int roomNumber, String description,
              int n, int s, int e, int w, String puzzle,
              String monster, String items, String fixtures,
              String picture) {
    this.game = game;
    this.NAME = roomName;
    this.NUMBER = roomNumber;
    this.DESCRIPTION = description;
    this.neighbors = new RoomNeighbors(this.game.getRooms());
    setObstacle(monster, puzzle);
    this.roomItems = new Bag(13);
    setRoomItems(items);
    this.roomFixtures = new RoomContents();
    setRoomFixtures(fixtures);
    this.PICTURE = picture;
  }

  /**
   * Room constructor that takes in a Game and a RoomData object. The Game is set as the Room's
   * game attribute so the room can access any necessary data from the Game class. The RoomData
   * object is an intermediary class between Room and the JSON file containing the data
   * specifications for a specific Room instance.
   *
   * @param game Room's game attribute
   * @param data attribute data for Room
   */
  public Room(Game game, RoomData data) {
    this.game = game;
    this.NAME = data.getRoomName();
    this.NUMBER = data.getRoomNumber();
    this.DESCRIPTION = data.getDescription();
    this.PICTURE = data.getPicture();

    // Save room numbers of neighbor rooms in an array
    int[] directions = {data.getN(), data.getS(), data.getE(), data.getW()};
    this.directions = directions;

    // Set room obstacle so there is no more than one monster XOR puzzle
    setObstacle(data.getMonster(), data.getPuzzle());

    // Fill roomItems attribute with Item instances created with ItemData instances
    this.roomItems = new RoomContents();
    setRoomItems(data.getItems());

    // Fill roomFixtures attribute with Fixtures instances created with FixtureData instances
    this.roomFixtures = new RoomContents();
    setRoomFixtures(data.getFixtures());
  }

  /**
   * Creates a RoomNeighbors class that tracks a room's neighboring rooms.
   *
   * @param rooms list of all room's in Game
   */
  public void createNeighbors(List<Room> rooms) {
    this.neighbors = new RoomNeighbors(rooms);
    setNeighbors(this.directions);
  }

  /**
   * Sets the neighbor rooms based on the numbers from the JSON data. The order of the numbers in
   * the directions array must be n, s, e, w.
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

  /**
   * Returns the room number of the neighboring room at the given CardinalDirection.
   *
   * @param direction direction of neighboring room from current room
   *
   * @return neighboring room number
   */
  public int getNeighborNumber(CardinalDirection direction) {
    return neighbors.getRoomNumber(direction);
  }

  /**
   * Returns room obstacle.
   *
   * @return room's obstacle
   */
  public IObstacle getObstacle() {
    return obstacle;
  }

  /**
   * Returns room picture.
   *
   * @return room's picture
   */
  public String getPicture() {
    return PICTURE;
  }

  /**
   * Returns the RoomFixtures attribute.
   *
   * @return roomFixtures
   */
  public IHolder<IElements> getRoomFixtures() {
    return roomFixtures;
  }

  /**
   * Returns the roomFixtures attribute in list form.
   *
   * return list of room fixtures
   */
  public List<IElements> getRoomFixturesList() {
    return roomFixtures.getItem();
  }

  /**
   * Returns the roomItems attribute.
   *
   * @return roomItems
   */
  public IHolder<IElements> getRoomItems() {
    return this.roomItems;
  }

  /**
   * Returns the roomItems attribute in list form
   *
   * @return list of items in room
   */
  public List<IElements> getRoomItemsList() {
    return this.roomItems.getItem();
  }

  /**
   * Takes in a "solution" for the room's obstacle (enemy or puzzle). Returns a String
   * stating the outcome (success or failure) or if nothing happened (i.e., there is no obstacle
   * present.
   *
   * @param solution
   * @return
   */
  public String solveObstacle(String solution) {

    // Check that there is an obstacle
    if (obstacle != null) {

      // Get success or failure response from the obstacle class
      String response = this.obstacle.checkSolution(solution);

      // "Unlock" any rooms that were blocked by the obstacle if the solution was successful
      if (!this.obstacle.getActiveState()) {
        this.neighbors.unlockRooms();
      }

      return response;
    }

    // If there is no obstacle, there is nothing to solve!
    return "Nothing happened!";
  }

  @Override
  public String toString() {

    if (roomItems != null && !roomItems.getItem().isEmpty()) {
      return "You are in " + NAME + ".\n"
              + DESCRIPTION + "\n"
              + roomItems.toString();
    } else {
      return "You are in " + NAME + ".\n"
              + DESCRIPTION + "\n"
              + "There are no items in this room.";
    }
  }
}