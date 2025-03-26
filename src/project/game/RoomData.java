package project.game;

import com.google.gson.annotations.SerializedName;

public class RoomData {
  @SerializedName("room_name")
  private String roomName;
  @SerializedName("room_number")
  private String roomNumber;

  @SerializedName("description")
  private String description;

  @SerializedName("N")
  private int N;

  @SerializedName("S")
  private int S;

  @SerializedName("E")
  private int E;

  @SerializedName("W")
  private int W;

  @SerializedName("puzzle")
  private String puzzle;

  @SerializedName("monster")
  private String monster;

  @SerializedName("items")
  private String items;

  @SerializedName("fixtures")
  private String fixtures;

  @SerializedName("picture")
  private String picture;

  public String getRoomName() {
    return roomName;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public String getDescription() {
    return description;
  }

  public String getN() {
    return N;
  }

  public String getS() {
    return S;
  }

  public String getE() {
    return E;
  }

  public String getW() {
    return W;
  }

  public String getPuzzle() {
    return puzzle;
  }

  public String getMonster() {
    return monster;
  }

  public String getItems() {
    return items;
  }

  public String getFixtures() {
    return fixtures;
  }

  public String getPicture() {
    return picture;
  }

  // Getters and Setters
}
