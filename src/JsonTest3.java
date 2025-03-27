import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import project.game.Game;
import project.game.JsonData;
import project.game.MonsterData;
import project.obstacle.Enemy;

/**
 * To ensure GSON is downloaded go to file->project structure->libraries and check that both
 * the gson and the errorprone libraries are downlaoded. If not, from there click the + sign in the
 * uppermost left hand corner, select "from Maven..." and in the search bar type
 * "google.code.gson" and download the most recent edition
 */
public class JsonTest3 {
  public static void main(String[] args) throws FileNotFoundException {

    try {

      Gson gson = new Gson();

      Enemy monster = new Enemy("Name", "true", "true", "true", "Carrot", "300", "Description", "Effects",
              "-15", "Target", "true", "attack", "picture");

      MonsterData monsterData = new MonsterData(monster);

      String json = gson.toJson(monsterData);

      System.out.println(json);

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
