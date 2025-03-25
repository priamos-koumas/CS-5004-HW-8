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
//  private final RoomNeighbors NEIGHBORS_ENEMY;
  private final RoomNeighbors NEIGHBORS;
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

    this.NEIGHBORS = new RoomNeighbors(this.game.getRooms());
//    makeEnemyNeighbors(directions);
//    this.NEIGHBORS = new RoomNeighbors(game.getRoom(Math.abs(n)), game.getRoom(s),
//                                        game.getRoom(e), game.getRoom(w));

    setObstacle(monster, puzzle);
    this.roomItems = new Bag(13);
    setRoomItems(items);
    this.roomFixtures = new RoomContents();
    setRoomFixtures(fixtures);
    this.PICTURE = picture;
    this.gameSet = false;
  }

  public Room(Game game, RoomData data) {
    this.game = game;
    this.NAME = data.getRoomName();
    this.NUMBER = Integer.parseInt(data.getRoomNumber());

    this.DESCRIPTION = data.getDescription();
    int[] directions = {Integer.parseInt(data.getN()),
            Integer.parseInt(data.getS()),
            Integer.parseInt(data.getE()),
            Integer.parseInt(data.getW())};
    this.NEIGHBORS = new RoomNeighbors(game.getRooms());
    setNeighbors(directions);
    this.PICTURE = data.getPicture();
    setObstacle(data.getMonster(), data.getPuzzle());
    this.roomItems = new RoomContents();
    setRoomItems(data.getItems());
    this.roomFixtures = new RoomContents();
    setRoomFixtures(data.getFixtures());
  }

  private void setNeighbors(int[] directions) {
    this.NEIGHBORS.setNeighbor(CardinalDirection.NORTH, directions[0]);
    this.NEIGHBORS.setNeighbor(CardinalDirection.SOUTH, directions[1]);
    this.NEIGHBORS.setNeighbor(CardinalDirection.EAST, directions[2]);
    this.NEIGHBORS.setNeighbor(CardinalDirection.WEST, directions[0]);
  }

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
  private void makeEnemyNeighbors(int[] directions) {

    for (int i = 0; i < directions.length; i++) {
      if (i == 0) {
        if (directions[i] <= 0) {
          NEIGHBORS_ENEMY.setNeighbor(CardinalDirection.NORTH, null);
        } else {
          NEIGHBORS_ENEMY.setNeighbor(CardinalDirection.NORTH, game.getRoom(directions[i]));
        }
      } else if (i == 1) {
        if (directions[i] <= 0) {
          NEIGHBORS_ENEMY.setNeighbor(CardinalDirection.SOUTH, null);
        } else {
          NEIGHBORS_ENEMY.setNeighbor(CardinalDirection.SOUTH, game.getRoom(directions[i]));
        }
      } else if (i == 2) {
        if (directions[i] <= 0) {
          NEIGHBORS_ENEMY.setNeighbor(CardinalDirection.EAST, null);
        } else {
          NEIGHBORS_ENEMY.setNeighbor(CardinalDirection.EAST, game.getRoom(directions[i]));
        }
      } else if (i == 3) {
        if (directions[i] <= 0) {
          NEIGHBORS_ENEMY.setNeighbor(CardinalDirection.WEST, null);
        } else {
          NEIGHBORS_ENEMY.setNeighbor(CardinalDirection.WEST, game.getRoom(directions[i]));
        }
      }
    }
  }
*/
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
    return NEIGHBORS.getRoom(direction);
  }

  /**
  public void setGame(Game2 game) {
    if (!gameSet) {
      this.game = game;
    }
    else {
      throw new IllegalArgumentException("game.Game is already set");
    }
  }
   */

  @Override
  public String toString() {
    return "room.Room{" +
            ", NAME='" + NAME + '\'' +
            ", NUMBER=" + NUMBER +
            ", DESCRIPTION='" + DESCRIPTION + '\'' +
            ", NEIGHBORS=" + NEIGHBORS +
            ", obstacle=" + obstacle +
            ", roomItems=" + roomItems +
            ", roomFixtures=" + roomFixtures +
            ", PICTURE='" + PICTURE + '\'' +
            '}' + "\n";
  }
}