package room;

import java.util.HashMap;
import java.util.Map;

/**
 * The room.RoomNeighbors class acts as a manager for a room.Room instance's "neighboring" rooms (i.e., the
 * rooms that a Player can access from the room they are currently in). These are stored using the
 * room.CardinalDirection enumeration to prevent more than four rooms being added.
 */
public class RoomNeighbors {
  private final Map<CardinalDirection, Room> NEIGHBORS;

  /**
   * RoomNeighbor's overloaded constructor takes in the room numbers of the four neighboring rooms
   * as integers, in the order north, south, east, and west in accordance with the JSON format.
   *
   * @param N room to north
   * @param S room to south
   * @param E room to east
   * @param W room to west
   */
  public RoomNeighbors(Room N, Room S, Room E, Room W) {
    NEIGHBORS = new HashMap<CardinalDirection, Room>();
    NEIGHBORS.put(CardinalDirection.NORTH, N);
    NEIGHBORS.put(CardinalDirection.SOUTH, S);
    NEIGHBORS.put(CardinalDirection.EAST, E);
    NEIGHBORS.put(CardinalDirection.WEST, W);
  }

  public RoomNeighbors() {
    NEIGHBORS = new HashMap<CardinalDirection, Room>();
  }

  public void setNeighbor(CardinalDirection direction, Room room) {
    if (NEIGHBORS.containsKey(direction)) {
      throw new IllegalArgumentException("Direction " + direction + " is already set");
    }
    NEIGHBORS.put(direction, room);
  }

  /**
   * Returns the room at the given room.CardinalDirection. Not a copy.
   *
   * @param direction direction of target room
   *
   * @return target room
   */
  public Room getRoom(CardinalDirection direction) {
    return NEIGHBORS.get(direction);
  }
}
