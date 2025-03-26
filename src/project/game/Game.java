package project.game;

import java.util.ArrayList;
import java.util.List;

import project.elements.Fixtures;
import project.elements.Item;
import project.obstacle.Enemy;
import project.obstacle.Puzzle;
import project.room.Room;

/**
 * The game.Game class is used to convert the game data from a given JSON file to Java classes.
 */
public class Game {
  private JsonData data;
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
   * @param data
   */
  public Game(JsonData data) {
//    this.data = data;
    this.name = data.getName();
    this.version = data.getVersion();
    this.items = new ArrayList<Item>();
    List<ItemData> itemData = data.getItems();
    setItems(itemData);
    this.fixtures = new ArrayList<>();
    List<FixtureData> fixtureData = data.getFixtures();
    setFixtures(fixtureData);
    this.monsters = new ArrayList<>();
    List<MonsterData> monsterData = data.getMonsters();
    setMonsters(monsterData);
    this.puzzles = new ArrayList<>();
    List<PuzzleData> puzzleData = data.getPuzzles();
    setPuzzles(puzzleData);
    this.rooms = new ArrayList<>();
    List<RoomData> roomData = data.getRooms();
    setRooms(roomData);
    setRoomNeighbors();
  }

  private void setRoomNeighbors() {
    for (Room room : rooms) {
      room.createNeighbors(this.rooms);
    }
  }

  private void setItems(List<ItemData> items) {
    for (ItemData item : items) {
      Item object = new Item(item);
      this.items.add(object);
    }
  }

  private void setFixtures(List<FixtureData> fixtures) {
    for (FixtureData fixture : fixtures) {
      Fixtures object = new Fixtures(fixture);
      this.fixtures.add(object);
    }
  }

  private void setMonsters(List<MonsterData> monsters) {
    for (MonsterData monster : monsters) {
      Enemy object = new Enemy(monster);
      this.monsters.add(object);
    }
  }

  private void setPuzzles(List<PuzzleData> puzzles) {
    for (PuzzleData puzzle : puzzles) {
      Puzzle object = new Puzzle(puzzle);
      this.puzzles.add(object);
    }
  }

  private void setRooms(List<RoomData> rooms) {
    for (RoomData room : rooms) {
      Room object = new Room(this, room);
      this.rooms.add(object);
    }
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

  public Item getItem(String name) {
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase(name)) {
        return item;
      }
    }
    return null;
  }

  public List<Fixtures> getFixtures() {
    return new ArrayList<>(fixtures);
  }

  public Fixtures getFixture(String name) {
    for (Fixtures fixture : fixtures) {
      if (fixture.getName().equalsIgnoreCase(name)) {
        return fixture;
      }
    }
    return null;
  }

  public List<Enemy> getMonsters() {
    return new ArrayList<>(monsters);
  }

  public Enemy getMonster(String name) {
    for (Enemy monster: monsters) {
      if (monster.getName().equalsIgnoreCase(name)) {
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
      if (puzzle.getName().equalsIgnoreCase(name)) {
        return puzzle;
      }
    }
    throw new IllegalArgumentException("Puzzle not found: " + name);
  }


  @Override
  public String toString() {
    return "Game2{" +
            "data=" + data +
            ", name='" + name + '\n' +
            ", version='" + version + '\n' +
            ", rooms=" + rooms + "\n" +
            ", items=" + items + "\n" +
            ", fixtures=" + fixtures + "\n" +
            ", monsters=" + monsters + "\n" +
            ", puzzles=" + puzzles + "\n" +
            '}';
  }
}
