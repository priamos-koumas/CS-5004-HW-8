package gamedriver;

import java.io.BufferedReader;
import java.io.StringReader;

public class Main {

  public static void main(String[] args) {

    // smoke tests - first send synthetic data via a string
    String s = "Team DEV-P\nL\nt hair clippers\nx self\nN\nt thumb drive\nN\nL\nu hair clippers\nt Lamp\nE\nTkey\nE\nT Algorithms Book\nW\nN\nU Lamp\nW\nQ\nYes\n";

    StringBuffer sb = new StringBuffer();

    BufferedReader stringReader = new BufferedReader(new StringReader(s));
    GameEngineApp gameEngineApp = new GameEngineApp("align_quest_game_elements.json", stringReader, sb);
    gameEngineApp.start();

    System.out.println(sb.toString());



/*
    StringBuffer sb = new StringBuffer();
    // Next, comment the above and uncomment this to do some ad-hoc testing by hand via System.in
     GameEngineApp gameEngineApp = new GameEngineApp("align_quest_game_elements.json", new InputStreamReader(System.in), sb);
     gameEngineApp.start();
    System.out.println(sb.toString());

 */






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
