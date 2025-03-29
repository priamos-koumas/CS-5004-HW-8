import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.*;

import gamedriver.GameCommandReaderNew;
import gamedriver.avatar.Avatar;
import gamedriver.avatar.AvatarController;
import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.room.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Controller test.
 */
public class AvatarControllerTest {
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

  GameCommandReaderNew userReader = new GameCommandReaderNew();

  /**
   * Test Avatar Constructor and Controller moving method.
   */
  @Test
  public void AvatarMoveTest() {
    AvatarController control = new AvatarController(game, userReader);
    String result = control.Control("L");

    assertEquals(game.getAvatar().getLoc().toString(), result);
    result = control.Control("N");

    assertEquals("Successfully move to next destination", result);

    result = control.Control("L");
    assertEquals(game.getAvatar().getLoc().toString(), result);

    result = control.Control("W");

    assertEquals("fail to move", result);


  }

  /**
   * Test controller pickup and drop and check player inventory method.
   */
  @Test
  public void AvatarPickupTest() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);

    result = control.Control("T", "Hair Clippers");
    assertEquals("There is nothing here", result);

    result = control.Control("I");
    assertEquals(game.getAvatar().getBag().toString(), result);
  }


  /**
   * test Examine method in controller.
   */
  @Test
  public void AvatarExamineTest() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);

    result = control.Control("X", "Hair Clippers");
    assertEquals("Cordless Wahl hair clippers for pets or humans. The battery low light is blinking.", result);

  }

  /**
   * test Drop item method in controller.
   */
  @Test
  public void AvatarDropItemTest() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);

    result = control.Control("D", "Hair Clippers");
    assertEquals("Item Dropped", result);

  }

  /**
   * test Drop item method in controller if fail.
   */
  @Test
  public void AvatarDropItemFailTest() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    control.Control("N");
    String result = control.Control("D", "Hair Clippers");
    assertEquals("There is no such thing in your bag", result);

  }

  /**
   * test Use item method in controller.
   */
  @Test
  public void AvatarUseItemTest() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);
    control.Control("N");
    control.Control("N");
    result = control.Control("U", "Hair Clippers");
    assertEquals("You have cleared the monster for 200 points!", result);

  }

  /**
   * test when the item reached its maximum usage.
   */
  @Test
  public void AvatarUseItemTestMax() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);
    control.Control("N");
    control.Control("U", "Hair Clippers");
    control.Control("U", "Hair Clippers");
    control.Control("U", "Hair Clippers");
    result = control.Control("U", "Hair Clippers");
    assertEquals("Maximum usage limit reached. Hair Clippers is destroyed", result);

  }

  /**
   * test if using an item that doesn't exist in the user inventory.
   */
  @Test
  public void AvatarUseItemFailTest() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    control.Control("N");
    String result = control.Control("U", "Hair Clippers");
    assertEquals("There is no such thing in your bag", result);

  }

  /**
   * test examine item.
   */
  @Test
  public void AvatarExamineItemTest() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);
    result = control.Control("X", "Hair Clippers");
    assertEquals("Cordless Wahl hair clippers for pets or humans. The battery low light is blinking.", result);

  }

  /**
   * test examine self.
   */
  @Test
  public void AvatarExamineSelf() {
    AvatarController control = new AvatarController(game, userReader);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);
    result = control.Control("X", "self");
    assertEquals(game.getAvatar().toString(), result);

  }

  /**
   * test Saving.
   */
  @Test
  public void SaveGameSelf() {
    AvatarController control = new AvatarController(game, userReader);

    String result = control.Control("V");

    Path path = Paths.get("Align Quest_save_file.json");

    if (Files.exists(path)) {
      assertEquals("Game saving", result);
    } else {
      assertEquals("Saving Failed", result);
    }

  }

  /**
   * test restore file.
   */
  @Test
  public void RestoreGameSelf() {
    AvatarController control = new AvatarController(game, userReader);
    Path path = Paths.get("Align Quest_save_file.json");

    if (Files.exists(path)) {
      String result = control.Control("R");
      assertEquals("Game restoring", result);
    } else {
      String result = control.Control("R");
      assertEquals("Game file not found.", result);
    }

  }



}


