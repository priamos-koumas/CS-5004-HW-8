package gamedriver.game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gamedriver.avatar.Avatar;
import gamedriver.elements.Fixtures;
import gamedriver.elements.Item;
import gamedriver.obstacle.Enemy;
import gamedriver.obstacle.Puzzle;
import gamedriver.room.Room;

/**
 * The Game class is the entry point to the video game model.
 */
public class Game {
  private String name;
  private String version;
  private Avatar avatar;
  private List<Room> rooms;
  private List<Item> items;
  private List<Fixtures> fixtures;
  private List<Enemy> monsters;
  private List<Puzzle> puzzles;

  /**
   * Game object are constructed with JsonData classes. JsonData acts as an intermediary between
   * a JSON file and the model. The game's name and version are set, followed by storage lists
   * of Item, Fixture, Monster, Puzzle, and Room instances, also created by their own Data files.
   * Then the avatar attribute is set. The avatar is either set as a default Avatar if it is a new
   * game or loaded from an AvatarData class from a loaded game.
   *
   * @param data attribute data for Game class
   */
  public Game(JsonData data) {

    if (data.getName() != null) {
      this.name = data.getName();
    } else {
      this.name = "";
    }

    if (data.getVersion() != null) {
      this.version = data.getVersion();
    } else {
      this.version = "";
    }

    // Create item list
    this.items = new ArrayList<Item>();
    List<ItemData> itemData = data.getItems();
    setItems(itemData);

    // Create fixture list
    this.fixtures = new ArrayList<>();
    List<FixtureData> fixtureData = data.getFixtures();
    setFixtures(fixtureData);

    // Create monster list
    this.monsters = new ArrayList<>();
    List<MonsterData> monsterData = data.getMonsters();
    setMonsters(monsterData);

    // Create puzzle list
    this.puzzles = new ArrayList<>();
    List<PuzzleData> puzzleData = data.getPuzzles();
    setPuzzles(puzzleData);

    // Create room list
    this.rooms = new ArrayList<>();
    List<RoomData> roomData = data.getRooms();
    setRooms(roomData);
    setRoomNeighbors();

    // Create avatar
    if (data.getAvatar() == null) {
      this.avatar = new Avatar(this);
    } else {
      this.avatar = new Avatar(this, data.getAvatar());
    }
  }

  /**
   * Used by the AvatarController class to load a game. Changes the data of this
   * game from current data to a new JSON data set.
   *
   * @param data Game attribute data
   */
  public void switchGame(JsonData data) {
    if (data.getName() != null) {
      this.name = data.getName();
    } else {
      this.name = "";
    }

    if (data.getVersion() != null) {
      this.version = data.getVersion();
    } else {
      this.version = "";
    }
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
    if (data.getAvatar() == null) {
      this.avatar = new Avatar(this);
    } else {
      this.avatar = new Avatar(this, data.getAvatar());
    }
  }

  /**
   * Sets every room's neighbor attribute. Must be done after ALL rooms are created because
   * the neighbor attribute stores Room objects, which must be already existing when the
   * neighbor attribute is created.
   */
  private void setRoomNeighbors() {
    for (Room room : rooms) {
      room.createNeighbors(this.rooms);
    }
  }

  /**
   * Fills the items attribute with Item objects that correspond to the data
   * in the ItemData class.
   *
   * @param items ItemData used to create Item objects
   */
  private void setItems(List<ItemData> items) {
    if (items != null) {
      for (ItemData itemData : items) {
        Item object = new Item(itemData);
        this.items.add(object);
      }
    }
  }

  /**
   * Fills the fixtures attribute with Fixtures objects that correspond to the data
   * in the FixtureData class.
   *
   * @param fixtures FixtureData used to create Fixtures objects
   */
  private void setFixtures(List<FixtureData> fixtures) {
    if (fixtures != null) {
      for (FixtureData fixture : fixtures) {
        Fixtures object = new Fixtures(fixture);
        this.fixtures.add(object);
      }
    }
  }

  /**
   * Fills the monsters attribute with Enemy objects that correspond to the data
   * in the MonsterData class.
   *
   * @param monsters MonsterData used to create Enemy objects
   */
  private void setMonsters(List<MonsterData> monsters) {
    if (monsters != null) {
      for (MonsterData monster : monsters) {
        Enemy object = new Enemy(monster);
        this.monsters.add(object);
      }
    }
  }

  /**
   * Fills the puzzles attribute with Puzzle classes that correspond to the data
   * in the PuzzleData class.
   *
   * @param puzzles PuzzleData used to create Puzzle Objects
   */
  private void setPuzzles(List<PuzzleData> puzzles) {
    for (PuzzleData puzzle : puzzles) {
      Puzzle object = new Puzzle(puzzle);
      this.puzzles.add(object);
    }
  }

  /**
   * Fills the rooms attribute with Room classes that correspond to the data
   * in the RoomData class.
   *
   * @param rooms RoomData used to create Room objects
   */
  private void setRooms(List<RoomData> rooms) {
    if (rooms != null) {
      for (RoomData room : rooms) {
        Room object = new Room(this, room);
        this.rooms.add(object);
      }
    } else {
      throw new IllegalArgumentException("There must be at least one room in a game");
    }
  }

  /**
   * Returns this game's avatar attribute.
   *
   * @return game's Avatar object
   */
  public Avatar getAvatar() {
    return avatar;
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

  /**
   * Returns a shallow copy of the items attribute.
   *
   * @return copy of item list
   */
  public List<Item> getItems() {
    return new ArrayList<>(items);
  }

  /**
   * Returns an item with the given string name or null if the item does
   * not exist.
   *
   * @param name item name
   *
   * @return desired item
   */
  public Item getItem(String name) {
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase(name)) {
        return item;
      }
    }
    return null;
  }

  /**
   * Return shallow copy of fixtures attribute.
   *
   * @return copy of fixtures list
   */
  public List<Fixtures> getFixtures() {
    return new ArrayList<>(fixtures);
  }

  /**
   * Returns a specific Fixture matching the given String name or returns null if
   * fixture does not exist.
   *
   * @param name Fixture name
   * @return desire fixture
   */
  public Fixtures getFixture(String name) {
    for (Fixtures fixture : fixtures) {
      if (fixture.getName().equalsIgnoreCase(name)) {
        return fixture;
      }
    }
    return null;
  }

  /**
   * Returns a shallow copy of the monsters attribute.
   *
   * @return copy of the monsters list
   */
  public List<Enemy> getMonsters() {
    return new ArrayList<>(monsters);
  }

  /**
   * Returns a specific Enemy matching the given String name or returns null if the Enemy
   * is not found.
   *
   * @param name monster name
   * @return desired monster
   */
  public Enemy getMonster(String name) {
    for (Enemy monster: monsters) {
      if (monster.getName().equalsIgnoreCase(name)) {
        return monster;
      }
    }
    return null;
  }

  /**
   * Returns a shallow copy of the puzzles attribute.
   *
   * @return copy of puzzle list
   */
  public List<Puzzle> getPuzzles() {
    return new ArrayList<>(puzzles);
  }

  /**
   * Returns a specific Puzzle with the matching string name or null if the Puzzle does not exist.
   *
   * @param name fixture name
   * @return desired fixture
   */
  public Puzzle getPuzzle(String name) {
    for (Puzzle puzzle : puzzles) {
      if (puzzle.getName().equalsIgnoreCase(name)) {
        return puzzle;
      }
    }
    return null;
  }

  /**
   * Saves the current Game instance in a json file through a JsonData class.
   */
  public void save() {

    // Save current game in file name "game_name_save_file.json"
    try (FileWriter writer = new FileWriter(this.getName() + "_save_file.json")) {

      // Create Gson object that converts objects into PrettyPrinting json files
      Gson gson = new GsonBuilder().setPrettyPrinting().create();

      // Create a JsonData file based on the current Game status
      JsonData gameData = new JsonData(this);

      // Send the JsonData to a json file
      gson.toJson(gameData, writer);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Restores a previous game by changing all the data in the current Game object with the
   * data from a JsonData object create from a json file.
   * @return
   */
    public boolean restore() {

    // Get file with name specifications from save() method
    try (FileReader reader = new FileReader(this.getName() + "_save_file.json")) {

      // Create gson that sets pretty printing
      Gson gson = new GsonBuilder().setPrettyPrinting().create();

      // Create a JsonData object from the json file
      JsonData gameData = gson.fromJson(reader, JsonData.class);

      // Change all data from current Game to data from gameData
      this.switchGame(gameData);

      // Return true if successful
      return true;
    } catch (FileNotFoundException e) {

      // Return false if file is not found
      return false;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    }

  @Override
  public String toString() {
    return "Game2{" +
            "avatar=" + avatar +
            ", name='" + name + '\n' +
            ", version='" + version + '\n' +
            ", rooms=" + rooms + "\n" +
            ", items=" + items + "\n" +
            ", fixtures=" + fixtures + "\n" +
            ", monsters=" + monsters + "\n" +
            ", puzzles=" + puzzles + "\n" +
            '}';
  }

  /**
   * Return game name.
   *
   * @return game name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Return game version.
   *
   * @return game version
   */
  public String getVersion() {
    return this.version;
  }
}
