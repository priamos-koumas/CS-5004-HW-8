package gamedriver;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import gamedriver.avatar.AvatarController;
import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.obstacle.IObstacle;

public class MainTest2 {

  public static void main(String[] args) {

    // smoke tests - first send synthetic data via a string
    String s = "Sir Mix-A-Lot\nT NOTEBOOK\nN\nT HAIR CLIPPERS\nT KEY\nD NOTEBOOK\nQuit";
    BufferedReader stringReader = new BufferedReader(new StringReader(s));
    GameEngineApp gameEngineApp = new GameEngineApp("./resources/align_quest_game_elements.json", stringReader, System.out);
    gameEngineApp.start();


    // Next, comment the above and uncomment this to do some ad-hoc testing by hand via System.in
    // GameEngineApp gameEngineApp = new GameEngineApp("./resources/museum.json", new InputStreamReader(System.in), System.out);
    // gameEngineApp.start();

    //}
    //
    //FileReader reader;
    //{
    //  try {
    //    reader = new FileReader("align_quest_game_elements.json");
    //  } catch (FileNotFoundException e) {
    //    throw new RuntimeException(e);
    //  }
    //}
    //
    //Gson gson = new Gson();
    //JsonData data = gson.fromJson(reader, JsonData.class);
    //Game game = new Game(data);
    //
    //GameCommandReaderNew userReader = new GameCommandReaderNew();
    //AvatarController control = new AvatarController(game, userReader);
    //control.go();
  }
}
