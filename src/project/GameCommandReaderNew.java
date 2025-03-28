package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

public class GameCommandReaderNew {

    private String [] data;
    private Readable in;
    private Appendable out;

    public GameCommandReaderNew() {
      this.in = new InputStreamReader(System.in);
      this.out = System.out;
      this.data = new String[2];
    }

    public GameCommandReaderNew(Readable in, Appendable out) {
      this.in = in;
      this.out = out;
      this.data = new String[2];
    }

    public boolean getDataFromUser() {
      try {
        Scanner scanner = new Scanner(this.in);
        this.out.append("To move, enter: (N)orth, (S)outh, (E)ast or (W)est.\n" +
                "Other actions: (I)nventory, (L)ook around the location, (U)se an item\n" +
                "(T)ake an item, (D)rop an item, or e(X)amine something. \n" +
                "(A)nswer a question or provide a text solution. \n" +
                "To end the game, enter (Q)uit to quit and exit.\n");
        for (int i = 0; i <= 1; i++) {
          if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String firstLetter = getFirstLetter(line);
            if (i == 0) {
              this.data[0] = firstLetter;

              this.data[1] = line.substring(firstLetter.length()).trim();
              return true;
            }
          }
        }
        return true;
      } catch (IOException e) {
        e.printStackTrace();
      }
      return false;
    }

    public String getOperator() {
      return this.data[0];
    }
    public String getOperand1() {
      return data[1];
  }


    //https://stackoverflow.com/questions/5067942/what-is-the-best-way-to-extract-the-first-word-from-a-string-in-java#comment17287574_5067993
    private String getFirstLetter(String text) {
      int index = text.indexOf(" ");
      if (index > -1) {
        return text.substring(0, index).trim();
      } else {
        return text;
      }
    }

  public static void main(String [] args) {

    String s = "T Hair Clippers\nQ\n";
    BufferedReader stringReader =
            new BufferedReader(new StringReader(s)); // source / input

    StringBuffer sb = new StringBuffer(); // sink / output

    GameCommandReaderNew reader =
            new GameCommandReaderNew(stringReader, sb);

    reader.getDataFromUser();

    System.out.println(sb);
    System.out.println(reader.getOperator());
    System.out.println(reader.getOperand1());
  }
}
