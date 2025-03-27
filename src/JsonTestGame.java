import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

import project.game.Game;
import project.game.JsonData;
import project.game.RoomData;
import project.room.Room;

/**
 * To ensure GSON is downloaded go to file->project structure->libraries and check that both
 * the gson and the errorprone libraries are downlaoded. If not, from there click the + sign in the
 * uppermost left hand corner, select "from Maven..." and in the search bar type
 * "google.code.gson" and download the most recent edition
 */
public class JsonTestGame {
  public static void main(String[] args) throws FileNotFoundException {

    try {

      Gson gson = new GsonBuilder().setPrettyPrinting().create();

      try(FileReader reader = new FileReader("align_quest_game_elements.json")) {

        JsonData data = gson.fromJson(reader, JsonData.class);
        Game game = new Game(data);

        JsonData newData = new JsonData(game);

        String json = gson.toJson(newData);

        System.out.println(json);

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }




//      try (FileWriter writer = new FileWriter("monster_data.json")) {
//        gson.toJson(monster, writer);
//        System.out.println("Data has been written to monster_data.json");
//      } catch (IOException e) {
//        e.printStackTrace();
//      }



    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
