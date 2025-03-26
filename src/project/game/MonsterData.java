package project.game;

import com.google.gson.annotations.SerializedName;

import project.obstacle.Enemy;

public class MonsterData {

  @SerializedName("name")
  private String name;
  
  @SerializedName("active")
  private String active;

  @SerializedName("affects_target")
  private String affectsTarget;

  @SerializedName("affects_player")
  private String affectsPlayer;

  @SerializedName("solution")
  private String solution;

  @SerializedName("value")
  private String value;

  @SerializedName("description")
  private String description;

  @SerializedName("effects")
  private String effects;
  
  @SerializedName("damage")
  private String damage;

  @SerializedName("target")
  private String target;

  @SerializedName("can_attack")
  private String canAttack;

  @SerializedName("attack")
  private String attack;

  @SerializedName("picture")
  private String picture;

  public MonsterData(Enemy monster) {
    this.name = monster.getName();
    this.active = String.valueOf(monster.getActiveState());
    this.affectsTarget = String.valueOf(monster.getAffectsTarget());
    this.affectsPlayer = String.valueOf(monster.getAffectsPlayer());
    this.solution = String.valueOf(monster.getSolution());
    this.value = String.valueOf(monster.getValue());
    this.description = String.valueOf(monster.getDescription());
    this.effects = String.valueOf(monster.getEffects());
    this.damage = String.valueOf(monster.getDamage());
    this.target = String.valueOf(monster.getTarget());
    this.canAttack = String.valueOf(monster.getCanAttack());
    this.attack = monster.getAttack();
    this.picture = monster.getImage();
  }

  public String getName() {
    return name;
  }

  public String getActive() {
    return active;
  }

  public String getAffectsTarget() {
    return affectsTarget;
  }

  public String getAffectsPlayer() {
    return affectsPlayer;
  }

  public String getSolution() {
    return solution;
  }

  public String getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }

  public String getEffects() {
    return effects;
  }

  public String getDamage() {
    return damage;
  }

  public String getTarget() {
    return target;
  }

  public String getCanAttack() {
    return canAttack;
  }

  public String getAttack() {
    return attack;
  }

  public String getPicture() {
    return picture;
  }

}
