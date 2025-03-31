package gamedriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class GameCommandReader {

    private String [] data;
    private String line;
    private Appendable out;
    private BufferedReader in2;
    private int j = 0;

    public GameCommandReader() {
      this.out = System.out;
      this.data = new String[2];
      this.in2 = new BufferedReader(new InputStreamReader(System.in));
    }

    public GameCommandReader(Reader in, Appendable out) {
      this.in2 = new BufferedReader(in);
      this.out = out;
      this.data = new String[2];
    }

    //https://stackoverflow.com/questions/16104616/using-bufferedreader-to-read-text-file
    // https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/
    // https://www.baeldung.com/java-buffered-reader
    public boolean getDataFromUser() {
      try {
        line = in2.readLine();
        if (line == null || line.isEmpty()) {
          return false;
        } else {
          line = line.trim();
        }
        String firstLetter = getFirstLetter(line);
        this.data[0] = firstLetter;
        this.data[1] = line.substring(firstLetter.length()).trim();
        return true;


      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
    }


    /**
     * Returns the first letter of the user input, which should be the user's one letter command
     * (e.g., t for take).
     *
     * @return user command
     */
    public String getCommand() {
        return this.data[0];
      }

    /**
     * Returns the rest of the string besides the first letter, which should include the details
     * of the command (e.g., hair clippers in the case of user input "t hair clippers").
     *
     * @return details of command
     */
    public String getDetails() {
      return data[1];
    }

  /**
   * Returns String of entire input from most recent call of getDataFromUser.
   *
   * @return input
   */
  public String getLine() {
      return this.line;
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

  /**
   * Sends the given String to the out appendable. Adds a line of blank space following
   * @param output
   */
  public void sendOut(String output) {
      try {
        this.out.append(output).append("\n");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

  public static void main(String [] args) {

    String s = "T Hair Clippers\nQ\n";
    BufferedReader stringReader =
            new BufferedReader(new StringReader(s)); // source / input

    StringBuffer sb = new StringBuffer(); // sink / output

    GameCommandReader reader =
            new GameCommandReader(stringReader, sb);

    reader.getDataFromUser();

    System.out.println(sb);
    System.out.println(reader.getCommand());
    System.out.println(reader.getDetails());
  }
}
