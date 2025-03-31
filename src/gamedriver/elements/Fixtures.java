package gamedriver.elements;

import gamedriver.game.FixtureData;

/**
 * Set up attributes of fixtures and extending name and description.
 */
public class Fixtures extends AbstractContents {
  int weight;
  private String puzzle;
  private String states;

  /**
   * Set up constructor of fixture class.
   * @param name name of fixture
   * @param description description of fixture
   * @param weight weight of fixture
   * @param puzzle puzzle (optional) of fixture
   * @param states state of fixture
   */
  public Fixtures(String name, String description, int weight, String puzzle, String states) {
    super(name, description);
    this.weight = weight;
    this.puzzle = puzzle;
    this.states = states;
  }

  /**
   * Set value of parameters of fixture parameters in case they are null.
   * @param data fixture data type.
   */
  public Fixtures(FixtureData data) {
    super(data.getName(), data.getDescription());

    if (data.getWeight() != null) {
      this.weight = Integer.parseInt(data.getWeight());
    } else {
      throw new IllegalArgumentException("Weight cannot be null");
    }

    if (data.getPuzzle() != null) {
      this.puzzle = data.getPuzzle();
    } else {
      this.puzzle = null;
    }

    if (data.getStates() != null) {
      this.states = data.getStates();
    } else {
      this.states = null;
    }

  }

  /**
   * Boolean method to see if a fixture is movable or not.
   * @return boolean value
   */
  public boolean isFixtureMovable() {
    return weight <= 200;
  }

  /**
   * Getter method used to return puzzle,
   * @return puzzle
   */
  public String getPuzzle() {
    return puzzle;
  }

  /**
   * Getter method to return state.
   * @return state
   */
  public String getStates() {
    return states;
  }

  /**
   * To string method to see what is being returned for weight
   * @return printed weight
   */
  @Override
  public String toString() {

    return "Fixtures{" +
            "weight=" + weight +
            '}';
  }

  /**
   * Getter method to return weight of fixture.
   * @return weight
   */
  @Override
  public int getWeight() {
    return this.weight;
  }

  /**
   * Needed for controller logic.
   */
  @Override
  public void decrementUsesRemaining() {
    return;
  }

  /**
   * Needed for controller logic.
   * @return 1
   */
  @Override
  public int usesRemaining(){
    return 1;
  }
}
