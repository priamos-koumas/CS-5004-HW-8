import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.elements.Item;
import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.room.Room;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The GameTest class tests the methods and constructor of the Game class, which is the entry
 * point to the video game model.
 */
class GameTest {

  FileReader reader;
  FileReader emptyReader;
  {
    try {
      reader = new FileReader("json_files/simple_hallway.json");
      emptyReader = new FileReader("json_files/empty_rooms.json");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  Gson gson = new Gson();
  JsonData data = gson.fromJson(reader, JsonData.class);
  Game game = new Game(data);
  JsonData emptyData = gson.fromJson(emptyReader, JsonData.class);
  Game emptyGame = new Game(emptyData);

  @Test
  void testNameConstruction() {

    assertEquals("Simple Hallway", game.getName());

    FileReader reader;
    {
      try {
        reader = new FileReader("json_files/simple_hallway_no_name.json");
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }

    Gson gson = new Gson();
    JsonData data = gson.fromJson(reader, JsonData.class);
    Game noNameGame = new Game(data);

    assertEquals("", noNameGame.getName());
  }

  @Test
  void testVersionConstruction() {
    assertEquals("1.0.0", game.getVersion());

    FileReader reader;
    {
      try {
        reader = new FileReader("json_files/simple_hallway_no_version.json");
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }

    Gson gson = new Gson();
    JsonData data = gson.fromJson(reader, JsonData.class);
    Game noVersionGame = new Game(data);

    assertEquals("", noVersionGame.getVersion());
  }

  @Test
  void testListConstruction() {

    // Test with filled rooms
    assertTrue(game.getItems().size() == 5);
    assertTrue(game.getFixtures().size() == 2);
    assertTrue(game.getMonsters().size() == 1);
    assertTrue(game.getPuzzles().size() == 2);

    // Test game with empty rooms
    assertTrue(emptyGame.getItems().isEmpty());
    assertTrue(emptyGame.getFixtures().isEmpty());
    assertTrue(emptyGame.getPuzzles().isEmpty());
    assertTrue(emptyGame.getMonsters().isEmpty());
  }

  @Test
  void testRoomConstruction() {

    // Test with rooms
    assertTrue(game.getRooms().size() == 4);

    // Test no rooms
    FileReader reader;
    {
      try {
        reader = new FileReader("json_files/no_rooms.json");
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }

    Gson gson = new Gson();
    JsonData data = gson.fromJson(reader, JsonData.class);

    assertThrows(IllegalArgumentException.class, () -> {
      Game noRooms = new Game(data);
    });
  }

  @Test
  void testAvatarConstruction() {

    // Test null Avatar
    assertEquals("", game.getAvatar().getName());
    assertEquals(100, game.getAvatar().getHealth());
    assertEquals(1, game.getAvatar().getLoc().getRoomNumber());
    assertTrue(game.getAvatar().getBag().getItem().isEmpty());

    // Test saved Avatar
    FileReader reader;
    {
      try {
        reader = new FileReader("json_files/simple_hallway_save_file.json");
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }

    Gson gson = new Gson();
    JsonData data = gson.fromJson(reader, JsonData.class);
    Game saveGame = new Game(data);

    assertEquals("Name", saveGame.getAvatar().getName());
    assertEquals(100, saveGame.getAvatar().getHealth());
    assertEquals(2, saveGame.getAvatar().getLoc().getRoomNumber());
    assertTrue(saveGame.getAvatar().getBag().getItem().size() == 1);
  }

  @Test
  void switchGame() {
    Game gameSwitch = new Game(emptyData);
    assertEquals("Empty Rooms", gameSwitch.getName());
    assertEquals("1.0.0", gameSwitch.getVersion());
    assertTrue(gameSwitch.getItems().isEmpty());
    assertTrue(gameSwitch.getFixtures().isEmpty());
    assertTrue(gameSwitch.getPuzzles().isEmpty());
    assertTrue(gameSwitch.getMonsters().isEmpty());

    gameSwitch.switchGame(data);

    assertEquals("Simple Hallway", gameSwitch.getName());
    assertEquals("1.0.0", gameSwitch.getVersion());
    assertTrue(gameSwitch.getItems().size() == 5);
    assertTrue(gameSwitch.getFixtures().size() == 2);
    assertTrue(gameSwitch.getMonsters().size() == 1);
    assertTrue(gameSwitch.getPuzzles().size() == 2);


  }

  @Test
  void getRooms() {
    assertEquals(4, game.getRooms().size());
    assertEquals(3, emptyGame.getRooms().size());
  }

  @Test
  void getRoom() {
    assertDoesNotThrow(() -> {
      Room room = game.getRoom(1);
      room.getObstacle();
      room.getRoomNumber();
      room.getRoomItems();
      room.getDescription();
    });

    assertThrows(IndexOutOfBoundsException.class, () -> game.getRoom(1000));
    assertThrows(IndexOutOfBoundsException.class, () -> emptyGame.getRoom(0));
    assertThrows(IndexOutOfBoundsException.class, () -> emptyGame.getRoom(-5));
  }

  @Test
  void getItems() {
    assertEquals(5, game.getItems().size());
    assertEquals(0, emptyGame.getItems().size());
  }

  @Test
  void getItem() {
  }

  @Test
  void getFixtures() {
    assertEquals(2, game.getFixtures().size());
    assertEquals(0, emptyGame.getFixtures().size());
  }

  @Test
  void getFixture() {
  }

  @Test
  void getMonsters() {
    assertEquals(1, game.getMonsters().size());
    assertEquals(0, emptyGame.getMonsters().size());
  }

  @Test
  void getMonster() {
  }

  @Test
  void getPuzzles() {
    assertEquals(2, game.getPuzzles().size());
    assertEquals(0, emptyGame.getPuzzles().size());
  }

  @Test
  void getPuzzle() {
  }

  @Test
  void save() {
  }

  @Test
  void restore() {
  }

  @Test
  void getName() {
  }

  @Test
  void getVersion() {
  }
}