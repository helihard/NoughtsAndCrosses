import java.util.ArrayList;

public class Player {
  private String name;
  private String marker;
  private ArrayList<Integer> claimedSquares;

  // empty constructor
  public Player() {
  }

  public Player(String name, String marker) {
    this.name = name;
    this.marker = marker;
     this.claimedSquares = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getMarker() {
    return marker;
  }

  public void addToClaimedSquares(int square) {
    this.claimedSquares.add(square);
  }
}
