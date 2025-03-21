import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * To ensure GSON is downloaded go to file->project structure->libraries and check that both
 * the gson and the errorprone libraries are downlaoded. If not, from there click the + sign in the
 * uppermost left hand corner, select "from Maven..." and in the search bar type
 * "google.code.gson" and download the most recent edition
 */
public class JsonTest {
  public static void main(String[] args) throws FileNotFoundException {

    try{

      FileReader reader = new FileReader("test.json");
      Gson gson = new Gson();

      // Create a new game class using the reader reading from the json file and the
      // gson object

      Game game = gson.fromJson(reader, Game.class);

      // Print game object
      System.out.println(game);
      System.out.println("\n");

      // Print individual rooms in game's room array
      for (Room room : game.getRooms()) {
        System.out.println(room);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
