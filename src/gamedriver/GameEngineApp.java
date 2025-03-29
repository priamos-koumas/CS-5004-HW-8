package gamedriver;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.avatar.AvatarController;
import gamedriver.game.Game;
import gamedriver.game.JsonData;

public class GameEngineApp {

  private String gameFileName = "align_quest_game_elements.json";
  private Readable source;
  private Appendable output;

  public GameEngineApp(String gameFileName, Readable source, Appendable output) {
	this.gameFileName = gameFileName;
	this.source = source;
	this.output = output;
  }

  // This is not working yet, and I am not sure why not. Vince

  public void start() {
	FileReader reader;

	{
	  try {
		reader = new FileReader(this.gameFileName);
	  } catch (FileNotFoundException e) {
		throw new RuntimeException(e);
	  }


	  Gson gson = new Gson();
	  JsonData data = gson.fromJson(reader, JsonData.class);
	  Game game = new Game(data);

	  //System.out.println("Please enter your name: ");
	  //game.getAvatar().setName();

	  GameCommandReaderNew userReader = new GameCommandReaderNew(this.source, this.output);
	  AvatarController control = new AvatarController(game, userReader);
	  control.go();
	}
  }
}
