import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

//import com.google.gson.Gson;


/**
 * The main class.
 */
public class Main {

  /**
   * This is the public static main.
   */
  public static void main(String [] args) throws IOException {

    IObstacle obstacle1 = new Puzzle("Test Obstacle Puzzle", "It's a riddle", "What has 2 legs...", false);
    IObstacle obstacle2 = new Enemy("Test Obstacle Enemy", "It's a monster", "Kill it", false, 75);

    System.out.println(obstacle1.getObstacleName());
    System.out.println(obstacle2.getObstacleName());




    //// smoke tests - first send synthetic data via a string
    //String s = "Sir Mix-A-Lot\nT NOTEBOOK\nN\nT HAIR CLIPPERS\nT KEY\nD NOTEBOOK\nQuit";
    //BufferedReader stringReader = new BufferedReader(new StringReader(s));
    //GameEngineApp gameEngineApp = new GameEngineApp("./resources/align_quest_game_elements.json",
    //         stringReader, System.out);
    //gameEngineApp.start();


    //// The above code is from the HW8
    //
    //// The below code is selected from the video and probably relies on classes we will build
    //// Work with Gson library
    //Gson gson = new Gson();
    //
    //// Read Json from package.json
    //try {
    //  FileReader reader = new FileReader("./empty_rooms.json");
    //  //Type type = new TypeToken<ArrayList<Thing>>(){}.getType(); Based on the demo https://www.youtube.com/watch?v=kooiBuJlcFg
    //  // need to decide what object to create probably not Object I think
    //  Object object = gson.fromJson(reader, Object.class);
    //  reader.close();
    //
    //  System.out.println(object.toString());
    //} catch (Exception e) {
    //  throw new RuntimeException(e);
    //}
  }
}