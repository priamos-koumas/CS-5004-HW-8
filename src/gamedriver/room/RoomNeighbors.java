package gamedriver.room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The RoomNeighbors class acts as a manager for a Room instance's "neighboring" rooms (i.e., the
 * rooms that a Player can access from the room they are currently in). These are stored using the
 * CardinalDirection enumeration to prevent more than four rooms being added.
 */
public class RoomNeighbors {
  private final Map<CardinalDirection, Integer> NEIGHBORS; // Rewrite so value is [Integer, Room]
  private List<Room> rooms;

  /**
   * RoomNeighbors constructor takes in a list including all the Room objects in a Game. The
   * CardinalDirections in the HashMap are not set until after all the room's have been created.
   *
   * @param rooms list of game's room objects
   */
  public RoomNeighbors(List<Room> rooms) {
    NEIGHBORS = new HashMap<CardinalDirection, Integer>();
    this.rooms = new ArrayList<Room>(rooms);
  }

  /**
   * Sets the value of the NEIGHBORS attribute at the given CardinalDirection to the given
   * room number.
   *
   * @param direction direction of neighboring room
   * @param room room number of neighbor
   */
  public void setNeighbor(CardinalDirection direction, int room) {
    if (NEIGHBORS.containsKey(direction)) {
      throw new IllegalArgumentException("Direction " + direction + " is already set");
    } else {
      NEIGHBORS.put(direction, room);
    }
  }

  /**
   * Returns the room at the given CardinalDirection. Not a copy. Returns null if the
   * neighboring room is blocked (either because there is no entrance or because a monster
   * or puzzle is blocking the entrance).
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

  /**
   * Unlocks any rooms blocked by an obstacle. This is done by turning any negative numbers
   * into their positive counterparts so the room is returned when called by the
   * getRoom method.
   */
  public void unlockRooms() {
    for (CardinalDirection direction : NEIGHBORS.keySet()) {
      if (NEIGHBORS.get(direction) < 0) {
        NEIGHBORS.put(direction, Math.abs(NEIGHBORS.get(direction)));
      }
    }
  }

  /**
   * Returns the room number of a room at the given CardinalDirection     .
   *
   * @param direction direction of neighboring room
   * @return room number of neighboring room
   */
  public int getRoomNumber(CardinalDirection direction) {
    return NEIGHBORS.get(direction);
  }

  /**
   * Returns the rooms attribute.
   *
   * @return list of rooms
   */
  public List<Room> getRooms() {
    return new ArrayList<Room>(rooms);
  }
}
