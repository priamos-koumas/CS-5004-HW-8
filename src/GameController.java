import java.io.IOException;

public class GameController implements IController {
  private UserInputReader reader;

  public GameController(UserInputReader reader) {
    this.reader = new UserInputReader();
  }

  @Override
  public void go() throws IOException {
    while (this.reader.getInputFromUser()) {
      if (this.reader.getData().toUpperCase() == "N") {
        // GO NORTH
      }
    }
  }
}
