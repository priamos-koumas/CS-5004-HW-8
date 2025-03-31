package gamedriver.elements;

/**
 * Implemented methods within items and fixtures.
 */
public interface IElements {
  String getName();
  String getDescription();
  int getWeight();
  public void decrementUsesRemaining();
  public int usesRemaining();
}
