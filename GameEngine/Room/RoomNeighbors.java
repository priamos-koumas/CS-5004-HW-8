package GameEngine.Room;

import java.util.HashMap;
import java.util.Map;

import GameEngine.Avatar.Direction;

public class RoomNeighbors {

  private final Map<Direction, Room> NEIGHBORS;

  /**
   * RoomNeighbor's overloaded constructor takes in the room numbers of the four neighboring rooms
   * as integers, in the order north, south, east, and west in accordance with the JSON format.
   */
  public RoomNeighbors() {
    NEIGHBORS = new HashMap<Direction, Room>();
  }

  public void addDirectionRoom(Direction dir, Room room) {
    this.NEIGHBORS.put(dir, room);
  }

  /**
   * Returns the room at the given CardinalDirection. Not a copy.
   *
   * @param direction direction of target room
   *
   * @return target room
   */
  public Room getRoom(Direction direction) {
    return NEIGHBORS.get(direction);
  }
}
