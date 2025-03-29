package game;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.game.MonsterData;
import gamedriver.obstacle.Enemy;
import gamedriver.game.PuzzleData;
import gamedriver.game.Game;
import gamedriver.game.JsonData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This tests the data class and specifically ensures the monster data
 * is pulled in correctly when it is read from the json files.
 */
public class PuzzleDataTest {
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

  PuzzleData puzzle0 = data.getPuzzles().get(0);
  PuzzleData puzzle1 = data.getPuzzles().get(1);

  /**
   * Tests the name is pulled properly.
   */
  @Test
  void testGetPuzzleDataNames() {
	assertEquals("DARKNESS", puzzle0.getName());
	assertEquals("MOD-SPOOKY-VOICE", puzzle1.getName());
  }

  /**
   * Tests the active is pulled properly.
   */
  @Test
  void testGetPuzzleDataActive() {
	assertEquals("true", puzzle0.getActive());
	assertEquals("true", puzzle1.getActive());
  }

  /**
   * Tests the target affects is pulled properly.
   */
  @Test
  void testGetPuzzleDataAffectsTarget() {
	assertEquals(null, puzzle0.getAffectsTarget());
	assertEquals(null, puzzle1.getAffectsTarget());
  }
  /**
   * Tests the player affects is pulled properly.
   */
  @Test
  void testGetPuzzleDataAffectsPlayer() {
	assertEquals("true", puzzle0.getAffectsPlayer());
	assertEquals("false", puzzle1.getAffectsPlayer());
  }

  /**
   * Tests the solution is pulled properly.
   */
  @Test
  void testGetPuzzleDataSolution() {
	assertEquals("Lamp", puzzle0.getSolution());
	assertEquals("Modulo 2", puzzle1.getSolution());
  }

  /**
   * Tests the name is pulled properly.
   */
  @Test
  void testGetPuzzleValue() {
	assertEquals("150", puzzle0.getValue());
	assertEquals("400", puzzle1.getValue());
  }

  /**
   * Tests the description is pulled properly.
   */
  @Test
  void testGetPuzzleDescription() {
	assertEquals("Darkness! You cannot see!", puzzle0.getDescription());
	assertEquals("An spooky, eerie library. You walked into this eerie library FROM the west. " +
			"\nAnother room is north. Books are rustling by themselves on a bookshelf.", puzzle1.getDescription());
  }

  /**
   * Tests the effects is pulled properly.
   */
  @Test
  void testGetPuzzleEffects() {
	assertEquals("It's dark! You cannot see anything! Maybe we should go back?", puzzle0.getEffects());
	assertEquals("Books are rustling by themselves on the bookshelf. That's a weird bookshelf. Really weird." +
			"\nYou hear a voice whisper: " +
			"\"~Find Even Numbers Only~\" " +
			"\nYikes. That's creepy. Maybe we should leave?", puzzle1.getEffects());
  }

  /**
   * Tests the room target is pulled properly.
   */
  @Test
  void testGetPuzzleTarget() {
	assertEquals("6:Kitchen", puzzle0.getTarget());
	assertEquals("4:Spooky Library", puzzle1.getTarget());
  }





}


