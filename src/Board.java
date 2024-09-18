import java.util.Arrays;

public class Board {
  private String[] squares = new String[9];

  // constructor
  public Board() {
    Arrays.fill(this.squares, "-");
    printBoard();
  }

  public void printBoard() {
    System.out.println(" " + this.squares[0] + " | " + this.squares[1] + " | " + this.squares[2]);
    System.out.println("–––+–––+–––");
    System.out.println(" " + this.squares[3] + " | " + this.squares[4] + " | " + this.squares[5]);
    System.out.println("–––+–––+–––");
    System.out.println(" " + this.squares[6] + " | " + this.squares[7] + " | " + this.squares[8]);
  }
}
