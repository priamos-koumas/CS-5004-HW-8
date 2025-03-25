package project.avatar;

public enum HEALTH_STATUS {
  SLEEP("SLEEP"), WOOZY("WOOZY"), FATIGUED("FATIGUED"), AWAKE("AWAKE");
  private String txt;

  /**
   * Assigns the first letter of each direction as its string value.
   *
   * @param txt direction's first letter
   */
  HEALTH_STATUS(String txt) {
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
