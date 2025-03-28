package gamedriver.avatar;

public enum Direction {
  NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");
  private String txt;

  /**
   * Assigns the first letter of each direction as its string value.
   *
   * @param txt direction's first letter
   */
  Direction(String txt) {
    this.txt = txt;
  }

  /**
   * Returns direction's txt value.
   * @return CardinalDirection's txt value
   */
  String getText() {
    return txt;
  }
}
