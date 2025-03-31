package game;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import gamedriver.GameCommandReader;
import gamedriver.avatar.Avatar;
import gamedriver.avatar.AvatarController;
import gamedriver.game.AvatarData;
import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.game.RoomData;
import gamedriver.room.Room;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvatarDataTest {

  private int health;
  private String name;
  private String bag;
  private int room;
  private final String gameFileName = "align_quest_game_elements.json";


  @Test
  public void testAvatarData() {
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

	  String s = "T Hair Clippers\nQ\n";
	  BufferedReader stringReader =
			  new BufferedReader(new StringReader(s)); // source / input

	  StringBuffer sb = new StringBuffer(); // sink / output

	  GameCommandReader gameReader =
			  new GameCommandReader(stringReader, sb);

	  GameCommandReader userReader = new GameCommandReader(stringReader, sb);
	  AvatarController control = new AvatarController(game, userReader);
	  RoomData room1 = data.getRooms().get(0);
	  Avatar avatar = new Avatar(100, "Ronald", new Room(game, room1));
	  AvatarData avatarData = new AvatarData(avatar);

	  assertEquals("Ronald", avatarData.getName());
	  assertEquals(100, avatarData.getHealth());
	  assertEquals("", avatarData.getBag());
	  assertEquals(1, avatarData.getRoom());

	}
  }
}
