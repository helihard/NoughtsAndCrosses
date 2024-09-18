public class Player {
  private String name;
  private String marker;

  // empty constructor
  public Player() {

  }

  public Player(String name, String marker) {
    this.name = name;
    this.marker = marker;
  }

  public String getName() {
    return name;
  }

  public String getMarker() {
    return marker;
  }
}
