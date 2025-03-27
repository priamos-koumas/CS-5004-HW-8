package project.game;

import com.google.gson.annotations.SerializedName;

import project.obstacle.Enemy;
import project.obstacle.Puzzle;
import project.room.CardinalDirection;
import project.room.Room;

public class RoomData {
  @SerializedName("room_name")
  private String roomName;

  @SerializedName("room_number")
  private int roomNumber;

  @SerializedName("description")
  private String description;

  @SerializedName("N")
  private int N;

  @SerializedName("S")
  private int S;

  @SerializedName("E")
  private int E;

  @SerializedName("W")
  private int W;

  @SerializedName("puzzle")
  private String puzzle;

  @SerializedName("monster")
  private String monster;

  @SerializedName("items")
  private String items;

  @SerializedName("fixtures")
  private String fixtures;

  @SerializedName("picture")
  private String picture;

  public RoomData(Room room) {
    this.roomName = room.getRoomName();
    this.roomNumber = room.getRoomNumber();
    this.description = room.getDescription();
    this.N = room.getNeighbor(CardinalDirection.NORTH).getRoomNumber();
    this.S = room.getNeighbor(CardinalDirection.SOUTH).getRoomNumber();
    this.E = room.getNeighbor(CardinalDirection.EAST).getRoomNumber();
    this.W = room.getNeighbor(CardinalDirection.WEST).getRoomNumber();
    if (room.getObstacle().getClass() == Enemy.class) {
      this.monster = room.getObstacle().getName();
    } else if (room.getObstacle().getClass() == Puzzle.class) {
      this.puzzle = room.getObstacle().getName();
    }
    for (int i = 0; i < room.getRoomItemsList().size() - 1; i++) {
      this.items += (room.getRoomItemsList().get(0).getName() + ", ");
    }
    this.items += room.getRoomItemsList().get(room.getRoomItemsList().size() - 1).getName();
    for (int i = 0; i < room.getRoomFixturesList().size() - 1; i++) {
      this.fixtures += (room.getRoomFixturesList().get(i).getName() + ", ");
    }
    this.fixtures += room.getRoomFixturesList().get(room.getRoomFixturesList().size()).getName();
    this.picture = room.getPicture();
  }

  public String getRoomName() {
    return roomName;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public String getDescription() {
    return description;
  }

  public int getN() {
    return N;
  }

  public int getS() {
    return S;
  }

  public int getE() {
    return E;
  }

  public int getW() {
    return W;
  }

  public String getPuzzle() {
    return puzzle;
  }

  public String getMonster() {
    return monster;
  }

  public String getItems() {
    return items;
  }

  public String getFixtures() {
    return fixtures;
  }

  public String getPicture() {
    return picture;
  }
}
