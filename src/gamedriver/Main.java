package gamedriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {

  public static void main(String[] args) {

    // smoke tests - first send synthetic data via a string


    String s = "Team DEV-P\nT hair clippers\nN\nt modulo 2\nt thumb drive\nN\nu hair clippers\nt lamp\nE\nT key\nu modulo 2\nE\nT Algorithms Book\nW\nN\nU lamp\nW\nS\nt Carrot\nN\nu Carrot\nN\nu thumb drive\nE\nQ\n";

    StringBuffer sb = new StringBuffer();

    BufferedReader stringReader = new BufferedReader(new StringReader(s));
    GameEngineApp gameEngineApp = new GameEngineApp("align_quest_game_elements.json", stringReader, sb);
    gameEngineApp.start();

    System.out.println(sb.toString());


    //StringBuffer sb = new StringBuffer();
    //// Next, comment the above and uncomment this to do some ad-hoc testing by hand via System.in
    //GameEngineApp gameEngineApp = new GameEngineApp("align_quest_game_elements.json", new InputStreamReader(System.in), sb);
    //gameEngineApp.start();
    //System.out.println(sb.toString());







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
