import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInputReader {
  private String data;
  private Readable in;
  private Appendable out;

  public UserInputReader() {
    this.in = new InputStreamReader(System.in);
    this.out = System.out;
    this.data = "";
  }

  public UserInputReader(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
    this.data = "";
  }

  public boolean getInputFromUser() {

    try {
      Scanner scanner = new Scanner(in);
      this.out.append("To move, enter: (N)orth, (S)outh, (E)ast or (W)est.\n" +
              "Other actions: (I)nventory, (L)ook around the location, (U)se an item\n" +
              "(T)ake an item, (D)rop an item, or e(X)amine something. \n" +
              "(A)nswer a question or provide a text solution. \n" +
              "To end the game, enter (Q)uit to quit and exit.\n");
      if (scanner.hasNextLine()) {
        this.data = String.valueOf(scanner.next().charAt(0));
        if (this.data.equalsIgnoreCase("Q")) {
          return false;
        }
      }
      return true;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public String getData() {
    return this.data;
  }

  public static void main(String[] args) {

    UserInputReader reader = new UserInputReader();

    while(reader.getInputFromUser()) {
      System.out.println(reader.getData());
    }
  }
}
