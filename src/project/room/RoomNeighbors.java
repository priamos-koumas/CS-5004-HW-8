package project.room;

import java.util.ArrayList;
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
  public RoomNeighbors(List<Room> rooms) {
    NEIGHBORS = new HashMap<CardinalDirection, Integer>();
    this.rooms = new ArrayList<Room>(rooms);
  }

  public void setNeighbor(CardinalDirection direction, int room) {
    if (NEIGHBORS.containsKey(direction)) {
      throw new IllegalArgumentException("Direction " + direction + " is already set");
    } else {
      NEIGHBORS.put(direction, room);
    }
  }

  /**
   * Returns the room at the given room.CardinalDirection. Not a copy.
   *
   * @param direction direction of target room
   *
   * @return target room
   */
  public Room getRoom(CardinalDirection direction) {
    if (NEIGHBORS.get(direction) < 1) {
      return null;
    }
    return rooms.get(NEIGHBORS.get(direction) - 1);
  }

  public int getRoomNumber(CardinalDirection direction) {
    return NEIGHBORS.get(direction);
  }

  public List<Room> getRooms() {
    return new ArrayList<Room>(rooms);
  }
}
