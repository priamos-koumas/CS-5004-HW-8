package GameEngine.Room;

import java.util.List;

import GameEngine.Avatar.Direction;
import GameEngine.Holder.IHolder;
import GameEngine.Holder.bag;
import GameEngine.Item.IItem;

public class Room {

  private final String NAME;
  private final int NUMBER;
  private final String DESCRIPTION;
  private final RoomNeighbors NEIGHBORS;
  private IHolder roomItem;

  /**
   * Room's overloaded constructor takes in all the necessary elements that make up the Room
   * as specified below.
   * @param roomName the name of the room
   * @param roomNumber the room number
   * @param description a String description of the room
   */
  public Room(String roomName, int roomNumber, String description) {
    this.NAME = roomName;
    this.NUMBER = roomNumber;
    this.DESCRIPTION = description;
    this.NEIGHBORS = new RoomNeighbors();
    this.roomItem = new bag(50);
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


  public void setNeighbor(Direction direction, Room room) {

    this.NEIGHBORS.addDirectionRoom(direction, room);
    if (direction == Direction.NORTH) {
      room.getAllNeighbor().addDirectionRoom(Direction.SOUTH, this);
    }

    else if (direction == Direction.SOUTH) {
      room.getAllNeighbor().addDirectionRoom(Direction.NORTH, this);
    }

    else if (direction == Direction.WEST) {
      room.getAllNeighbor().addDirectionRoom(Direction.EAST, this);
    }

    else if (direction == Direction.EAST) {
      room.getAllNeighbor().addDirectionRoom(Direction.WEST, this);
    }

  }

  public Room getNeighbor(Direction direction) {
    return NEIGHBORS.getRoom(direction);
  }

  public RoomNeighbors getAllNeighbor() {
    return this.NEIGHBORS;
  }

  public List<IItem> getInventList() {
    return this.roomItem.getItem();
  }

  public IHolder getInvent() {
    return this.roomItem;
  }


  @Override
  public String toString() {
    return "Room{" +
            "NAME='" + NAME + '\'' +
            ", NUMBER=" + NUMBER +
            ", DESCRIPTION='" + DESCRIPTION + '\'' +
            ", Item=" + this.roomItem.toString() +
            '}';
  }

}
