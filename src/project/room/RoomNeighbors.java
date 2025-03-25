package project.room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The room.RoomNeighbors class acts as a manager for a room.Room instance's "neighboring" rooms (i.e., the
 * rooms that a Player can access from the room they are currently in). These are stored using the
 * room.CardinalDirection enumeration to prevent more than four rooms being added.
 */
public class RoomNeighbors {
  private final Map<CardinalDirection, Integer> NEIGHBORS; // Rewrite so value is [Integer, Room]
  private List<Room> rooms;

  /**
   * RoomNeighbor's overloaded constructor takes in the room numbers of the four neighboring rooms
   * as integers, in the order north, south, east, and west in accordance with the JSON format.
   */
//  public RoomNeighbors(int N, int S, int E, int W) {
//    NEIGHBORS = new HashMap<CardinalDirection, Integer>();
//    NEIGHBORS.put(CardinalDirection.NORTH, N);
//    NEIGHBORS.put(CardinalDirection.SOUTH, S);
//    NEIGHBORS.put(CardinalDirection.EAST, E);
//    NEIGHBORS.put(CardinalDirection.WEST, W);
//  }

  public RoomNeighbors(List<Room> rooms) {
    NEIGHBORS = new HashMap<CardinalDirection, Integer>();
    this.rooms = rooms;
  }

  public void setNeighbor(CardinalDirection direction, int room) {
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
    return rooms.get(NEIGHBORS.get(direction) - 1);
  }
}
