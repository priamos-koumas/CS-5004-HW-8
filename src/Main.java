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
    // Enemy smoke test
    IObstacle obstacle1 = new Enemy("Rabbit", "true", "true", "true", "Carrot", "300",
            "Awww. A furry rabbit twitching its nose and eating a carrot. Makes you want to pet him",
            "A monster Rabbit moves towards you! He's blocking the way north. \nI think you might be dinner!", "-15", "7:Dining Room", "true",
            "licks you with a giant tongue!", "monster-rabbit.png");
    System.out.println("*****ENEMY*****");
    System.out.println("*******Name********");
    System.out.println(obstacle1.getName());
    System.out.println("*******ActiveObstacle********");
    System.out.println(obstacle1.getActiveState());
    System.out.println("*******AffectsTarget********");
    System.out.println(obstacle1.getAffectsTarget());
    System.out.println("*******AffectsPlayer********");
    System.out.println(obstacle1.getAffectsPlayer());
    System.out.println("*******Solution********");
    System.out.println(obstacle1.getSolution());
    System.out.println("*******Value********");
    System.out.println(obstacle1.getValue());
    System.out.println("*******Description********");
    System.out.println(obstacle1.getDescription());
    System.out.println("*******Effects********");
    System.out.println(obstacle1.getEffects());
    System.out.println("*******Damage********");
    System.out.println(obstacle1.getDamage());
    System.out.println("*******TargetRoom********");
    System.out.println(obstacle1.getTarget());
    System.out.println("*******Can Attack********");
    System.out.println(obstacle1.getCanAttack());
    System.out.println("*******Attack********");
    System.out.println(obstacle1.getAttack());
    System.out.println("*******Image********");
    System.out.println(obstacle1.getImage());

    // Enemy smoke test
    IObstacle obstacle2 = new Puzzle("DARKNESS", "true", "true", "true", "Lamp", "150",
            "Darkness! You cannot see!",
            "It's dark! You cannot see anything! Maybe we should go back?", "6:Kitchen",  "darkness.png");
    System.out.println("*****PUZZLE*****");
    System.out.println("*******Name********");
    System.out.println(obstacle2.getName());
    System.out.println("*******ActiveObstacle********");
    System.out.println(obstacle2.getActiveState());
    System.out.println("*******AffectsTarget********");
    System.out.println(obstacle2.getAffectsTarget());
    System.out.println("*******AffectsPlayer********");
    System.out.println(obstacle2.getAffectsPlayer());
    System.out.println("*******Solution********");
    System.out.println(obstacle2.getSolution());
    System.out.println("*******Value********");
    System.out.println(obstacle2.getValue());
    System.out.println("*******Description********");
    System.out.println(obstacle2.getDescription());
    System.out.println("*******Effects********");
    System.out.println(obstacle2.getEffects());
    System.out.println("*******TargetRoom********");
    System.out.println(obstacle2.getTarget());
    System.out.println("*******Image********");
    System.out.println(obstacle2.getImage());







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