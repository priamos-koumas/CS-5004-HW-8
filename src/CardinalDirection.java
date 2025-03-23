/**
 * The CardinalDirection enumeration groups the four cardinal directions as constants.
 */
public enum CardinalDirection {
  NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");
  private String txt;

  /**
   * Assigns the first letter of each direction as its string value.
   *
   * @param txt direction's first letter
   */
  CardinalDirection(String txt) {
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
