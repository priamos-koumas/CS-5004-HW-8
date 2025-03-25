package project.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import project.elements.Fixtures;
import project.elements.Item;
import project.obstacle.Enemy;
import project.obstacle.Puzzle;
import project.room.Room;

/**
 * The game.Game class is used to convert the game data from a given JSON file to Java classes.
 */
public class GameOld {
  private String name;
  private String version;
  private List<Room> rooms;
  private List<Item> items;
  private List<Fixtures> fixtures;
  private List<Enemy> monsters;
  private List<Puzzle> puzzles;


  /**
   * game.Game objects are created with a name, a version number, and a List of room.Room objects.
   *
   * @param name name of the game.Game instance
   * @param version version number of the game.Game instance
   * @param rooms room.Room objects that make up the game's "map"
   */
  public GameOld(String name, String version, Room[] rooms, Item[] items, Fixtures[] fixtures, Enemy[] monsters, Puzzle[] puzzles) {
    this.name = name;
    this.version = version;
    this.items = new ArrayList<Item>(Arrays.asList(items));
    this.fixtures = new ArrayList<Fixtures>(Arrays.asList(fixtures));
    this.monsters = new ArrayList<Enemy>(Arrays.asList(monsters));
    this.puzzles = new ArrayList<Puzzle>(Arrays.asList(puzzles));
    this.rooms = new ArrayList<Room>(Arrays.asList(rooms));
//    for (Room room : rooms) {
//      room.setGame(this);
//    }

  }

  /**
   * Returns a shallow copy of the game.Game's rooms in an ArrayList.
   *
   * @return game.Game's rooms
   */
  public List<Room> getRooms() {
    return new ArrayList<Room>(rooms);
  }

  /**
   * Return's a single room.Room instance given the room number. The index is offset because room numbers
   * are one-indexed.
   *
   * @param roomNumber desired room.Room instance's room number.
   *
   * @return desire room.Room
   */
  public Room getRoom(int roomNumber) {
    int index = roomNumber - 1;
    if (index < 0 || index >= rooms.size()) {
      throw new IndexOutOfBoundsException("Invalid room number: " + roomNumber);
    }
    return rooms.get(index);
  }

  public List<Item> getItems() {
    return new ArrayList<>(items);
  }

  public List<Fixtures> getFixtures() {
    return new ArrayList<>(fixtures);
  }

  public List<Enemy> getMonsters() {
    return new ArrayList<>(monsters);
  }

  public Enemy getMonster(String name) {
    for (Enemy monster: monsters) {
      if (monster.getName().equals(name)) {
        return monster;
      }
    }
    return null;
  }

  public List<Puzzle> getPuzzles() {
    return new ArrayList<>(puzzles);
  }

  public Puzzle getPuzzle(String name) {
    for (Puzzle puzzle : puzzles) {
      if (puzzle.getName().equals(name)) {
        return puzzle;
      }
    }
    throw new IllegalArgumentException("Puzzle not found: " + name);
  }

  @Override
  public String toString() {
    return "game.Game{" +
            "name='" + name + '\n' +
            ", version='" + version + '\n' +
            ", rooms=" + rooms + '\n' +
            '}';
  }
}
