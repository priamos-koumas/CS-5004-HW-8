package elements;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.elements.Fixtures;
import gamedriver.game.Game;
import gamedriver.game.JsonData;

import static org.junit.jupiter.api.Assertions.*;


public class FixturesTest {
  FileReader reader;
  {
    try {
      reader = new FileReader("align_quest_game_elements.json");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  Gson gson = new Gson();
  JsonData data = gson.fromJson(reader, JsonData.class);
  Game game = new Game(data);

  Fixtures fixtures0 = game.getFixtures().get(0);
  Fixtures fixtures1 = game.getFixtures().get(1);
  Fixtures fixtures2 = game.getFixtures().get(2);

  @Test
  void testGetFixtureNames() {
    assertEquals("Desk", fixtures0.getName());
    assertEquals("Laptop", fixtures1.getName());
    assertEquals("Professor Keith", fixtures2.getName());
  }

  @Test
  void testGetFixtureWeight() {
    assertEquals(1000, fixtures0.getWeight());
    assertEquals(1000, fixtures1.getWeight());
    assertEquals(1000, fixtures2.getWeight());
  }

  @Test
  void testGetFixturePuzzle() {
    assertEquals(null, fixtures0.getPuzzle());
    assertEquals(null, fixtures1.getPuzzle());
    assertEquals(null, fixtures2.getPuzzle());
  }

  @Test
  void testGetFixtureStates() {
    assertEquals(null, fixtures0.getStates());
    assertEquals(null, fixtures1.getStates());
    assertEquals(null, fixtures2.getStates());
  }

  @Test
  void testFixturesIsMoveable() {
    assertFalse(fixtures0.isFixtureMovable());
    assertFalse(fixtures1.isFixtureMovable());
    assertFalse(fixtures2.isFixtureMovable());
  }


}
