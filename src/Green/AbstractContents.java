package Green;

import com.google.gson.annotations.SerializedName;


public class AbstractContents implements IElements {

  @SerializedName("name")
  private String name;

  @SerializedName("description")
  private String description;

  @SerializedName("weight")
  int weight;

  public AbstractContents(String name, String description, int weight) {
    this.name = name;
    this.description = description;
    this.weight = weight;
  }

  public String getDescription() {
    return description;
  }

  public int getWeight() {
    return weight;
  }

  public String getName() {
    return name;
  }
}
