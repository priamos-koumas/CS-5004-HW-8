import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import project.avatar.Avatar;
import project.avatar.AvatarController;
import project.avatar.IAvatar;
import project.game.Game;
import project.game.GameOld;
import project.game.JsonData;
import project.room.Room;

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

  Room room1 = game.getRooms().get(0);
  Room room2 = game.getRooms().get(1);
  Room room3 = game.getRooms().get(2);

  /**
   * Test Avatar Constructor and Controller moving method.
   */
  @Test
  public void AvatarMoveTest() {
    Avatar player = new Avatar(100, "Trevor", room1);
    AvatarController control = new AvatarController(player);
    String result = control.Control("L");

    assertEquals(room1.toString(), result);
    result = control.Control("N");

    assertEquals("Successfully move to next destination", result);

    result = control.Control("L");
    assertEquals(room3.toString(), result);

    result = control.Control("N");

    assertEquals("fail to move", result);


  }

  /**
   * Test controller pickup and drop and check player inventory method.
   */
  @Test
  public void AvatarPickupTest() {
    Avatar player = new Avatar(100, "Trevor", room1);
    AvatarController control = new AvatarController(player);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);

    result = control.Control("T", "Hair Clippers");
    assertEquals("There is nothing here", result);

    result = control.Control("I");
    assertEquals(player.getBag().toString(), result);
  }


  /**
   * test Examine method in controller.
   */
  @Test
  public void AvatarExamineTest() {
    Avatar player = new Avatar(100, "Trevor", room1);
    AvatarController control = new AvatarController(player);
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
    Avatar player = new Avatar(100, "Trevor", room1);
    AvatarController control = new AvatarController(player);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);

    result = control.Control("D", "Hair Clippers");
    assertEquals("Item Dropped", result);

  }

  /**
   * test Use item method in controller.
   */
  @Test
  public void AvatarUseItemTest() {
    Avatar player = new Avatar(100, "Trevor", room1);
    AvatarController control = new AvatarController(player);
    control.Control("L");
    String result = control.Control("T", "Hair Clippers");
    assertEquals("Successfully pick up", result);
    control.Control("N");

    result = control.Control("U", "Hair Clippers");
    assertEquals("You have cleared the monster for 200 points!", result);

  }
}
