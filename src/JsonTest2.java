import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import project.game.Game;
import project.game.JsonData;
import project.obstacle.Enemy;
import project.obstacle.Puzzle;

/**
 * To ensure GSON is downloaded go to file->project structure->libraries and check that both
 * the gson and the errorprone libraries are downlaoded. If not, from there click the + sign in the
 * uppermost left hand corner, select "from Maven..." and in the search bar type
 * "google.code.gson" and download the most recent edition
 */
public class JsonTest2 {
  public static void main(String[] args) throws FileNotFoundException {

    try{

      FileReader reader = new FileReader("simple_hallway.json");
      Gson gson = new Gson();

      // Create a new game class using the reader reading from the json file and the
      // gson object
      JsonData data = gson.fromJson(reader, JsonData.class);
      Game game = new Game(data);

      // Print game object
      System.out.println(data);
      System.out.println("\n");
      System.out.println(game);
      System.out.println("\n");

      //Print out example array
      for (Puzzle puzzle : game.getPuzzles()) {
        System.out.println(puzzle);
      }
      System.out.println("\n");

      for (Enemy monster: game.getMonsters()) {
        System.out.println(monster);
      }

    }
    catch (FileNotFoundException e) {
      throw new FileNotFoundException();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
