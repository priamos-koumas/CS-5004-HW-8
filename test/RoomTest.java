import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.obstacle.IObstacle;
import gamedriver.room.CardinalDirection;
import gamedriver.room.Room;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

  FileReader reader;
  {
    try {
      reader = new FileReader("json_files/align_quest_game_elements.json");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  Gson gson = new Gson();
  JsonData data = gson.fromJson(reader, JsonData.class);
  Game game = new Game(data);

  Room room1 = game.getRoom(1);
  Room room2 = game.getRoom(2);
  Room room3 = game.getRoom(3);
  Room room4 = game.getRoom(4);
  Room room6 = game.getRoom(6);

  @Test
  void getRoomName() {
    assertEquals("Courtyard", room1.getRoomName());
    assertEquals("Mansion Entrance", room2.getRoomName());
    assertEquals("Foyer", room3.getRoomName());
  }

  @Test
  void getRoomNumber() {
    assertEquals(1 , room1.getRoomNumber());
    assertEquals(2 , room2.getRoomNumber());
    assertEquals(3 , room3.getRoomNumber());
  }

  @Test
  void getDescription() {
    assertEquals("A beautiful courtyard with flowers on both sides of the stone walkway. "
            + "\nThe walkway leads north. A billboard is in the distance.", room1.getDescription());
    assertEquals("Entrance to an old, musty-smelling mansion. "
            + "Some people have entered, to never return. "
            + "\nThe door to the north is open. "
            + "The courtyard is to your south and a foyer to your north. "
            + "A chandelier hangs from the ceiling.", room2.getDescription());
    assertEquals("The foyer of the mansion. "
            + "A staircase leads upstairs but it is dilapidated and unusable. "
            + "Therefore, the only exits to the south and east. "
            + "\nA strange breeze moves through the room. "
            + "Eastward is a small room that looks like a library. "
            + "A teddy bear lies on the floor with its hair shaved", room3.getDescription());
  }

  @Test
  void testGetNeighbor() {

    assertEquals(game.getRoom(2).getRoomNumber(), room1.getNeighbor(CardinalDirection.NORTH).getRoomNumber());
    assertEquals(game.getRoom(1), room2.getNeighbor(CardinalDirection.SOUTH));
    assertEquals(game.getRoom(3), room2.getNeighbor(CardinalDirection.NORTH));
    assertEquals(game.getRoom(4), room3.getNeighbor(CardinalDirection.EAST));
    assertNull(room3.getNeighbor(CardinalDirection.WEST));

  }

  @Test
  void getNeighborNumber() {

    assertEquals(2, room1.getNeighborNumber(CardinalDirection.NORTH));
    assertEquals(0, room1.getNeighborNumber(CardinalDirection.SOUTH));
    assertEquals(0, room1.getNeighborNumber(CardinalDirection.WEST));
    assertEquals(0, room1.getNeighborNumber(CardinalDirection.EAST));

    // Should return negative numbers for blocked rooms
    assertEquals(-5, room4.getNeighborNumber(CardinalDirection.EAST));
  }

  @Test
  void getObstacle() {

    assertNull(room1.getObstacle());
    assertEquals(game.getMonster("Teddy Bear"), room3.getObstacle());
  }

  @Test
  void getRoomFixtures() {

    assertTrue(room3.getRoomFixtures().isEmpty());
    assertEquals(room1.getRoomFixtures().get(0), game.getFixture("Billboard"));
  }

  @Test
  void getRoomItems() {
    assertTrue(room6.getRoomItems().isEmpty());
    assertEquals(room1.getRoomItems().get(0), game.getItem("Hair Clippers"));


  }

  @Test
  void solveObstacle() {

    assertEquals("Nothing happened!", room1.solveObstacle("Hair Clippers"));
    assertEquals("You have cleared the monster for 200 points!", room3.solveObstacle("Hair Clippers"));
    assertEquals("You did not clear the monster.", room3.solveObstacle("Book"));

  }
}