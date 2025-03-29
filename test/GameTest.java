import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.elements.Fixtures;
import gamedriver.elements.Item;
import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.obstacle.Enemy;
import gamedriver.obstacle.Puzzle;
import gamedriver.room.Room;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

    assertEquals("Untitled", noNameGame.getName());
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

    assertEquals("Unversioned", noVersionGame.getVersion());
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
  void testInvalidRoomNumbers() {
    FileReader negativeReader;
    FileReader zeroReader;
    FileReader repeatReader;
    {
      try {
        negativeReader = new FileReader("json_files/empty_rooms_negative_room_number.json");
        zeroReader = new FileReader("json_files/empty_rooms_zero_room_number.json");
        repeatReader = new FileReader("json_files/empty_rooms_repeat_room_number.json");
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }

    Gson gson = new Gson();
    JsonData negativeData = gson.fromJson(negativeReader, JsonData.class);
    JsonData zeroData = gson.fromJson(zeroReader, JsonData.class);
    JsonData repeatData = gson.fromJson(repeatReader, JsonData.class);

    // Test game with negative room number
    assertThrows(IllegalArgumentException.class, () -> {
      Game negativeGame = new Game(negativeData);
    });

    // Test game with zero room number
    assertThrows(IllegalArgumentException.class, () -> {
      Game zeroGame = new Game(zeroData);
    });

    // Test game with repeat room number
    assertThrows(IllegalArgumentException.class, () -> {
      Game repeatGame = new Game(repeatData);
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

    assertDoesNotThrow(() -> {
      Item item = game.getItem("Hair Clippers");
      item.getName();
      item.getDescription();
      item.getUsesRemaining();
      item.getMaxUses();
    });

    assertNull(game.getItem("Book"));
  }

  @Test
  void getFixtures() {
    assertEquals(2, game.getFixtures().size());
    assertEquals(0, emptyGame.getFixtures().size());
  }

  @Test
  void getFixture() {
    assertDoesNotThrow(() -> {
      Fixtures fixture = game.getFixture("Painting");
      fixture.getDescription();
      fixture.getName();
      fixture.getWeight();
      fixture.getStates();
    });

    assertNull(game.getFixture("Fireplace"));
  }

  @Test
  void getMonsters() {
    assertEquals(1, game.getMonsters().size());
    assertEquals(0, emptyGame.getMonsters().size());
  }

  @Test
  void getMonster() {
    assertDoesNotThrow(() -> {
      Enemy monster = game.getMonster("Teddy Bear");
      monster.getName();
      monster.getDescription();
      monster.getDamage();
      monster.getValue();
    });
    assertNull(game.getMonster("Generic Monster"));
  }

  @Test
  void getPuzzles() {
    assertEquals(2, game.getPuzzles().size());
    assertEquals(0, emptyGame.getPuzzles().size());
  }

  @Test
  void getPuzzle() {
    assertDoesNotThrow(() -> {
      Puzzle puzzle = game.getPuzzle("Lock");
      puzzle.getDescription();
      puzzle.getName();
      puzzle.getValue();
      puzzle.getValue();
    });
    assertNull(game.getPuzzle("Puzzle"));
  }

  @Test
  void getName() {
    assertEquals("Simple Hallway", game.getName());
    assertEquals("Empty Rooms", emptyGame.getName());
  }

  @Test
  void getVersion() {
    assertEquals("1.0.0", game.getVersion());
    assertEquals("1.0.0", emptyGame.getVersion());
  }
}