import java.util.Arrays;
import java.util.Scanner;

public class Board {
  private Scanner scanner;
  private String[] squares = new String[9];

  // constructor
  public Board() {
    this.scanner = new Scanner(System.in);
    Arrays.fill(this.squares, "-");
    printBoard();
  }

  public void printBoard() {
    System.out.println("\n " + this.squares[0] + " | " + this.squares[1] + " | " + this.squares[2]);
    System.out.println("---+---+---");
    System.out.println(" " + this.squares[3] + " | " + this.squares[4] + " | " + this.squares[5]);
    System.out.println("---+---+---");
    System.out.println(" " + this.squares[6] + " | " + this.squares[7] + " | " + this.squares[8] + "\n");
  }

  public int getValidSquareNumber() {
    int number = - 1;
    boolean isValidInput = false;

    while(!isValidInput) {
      System.out.println("Enter a number between 1 and 9: ");
      String input = scanner.nextLine().trim();

      try {
        number = Integer.parseInt(input);
        if (number < 1 || number > 9) {
          System.out.println("Invalid input. Please enter a number between 1 and 9.");
        } else if (!this.squares[number - 1].equals("-")) {
          System.out.println("Square already claimed by player. Please choose another square.");
        } else {
          isValidInput = true;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number between 1 and 9.");
      }
    }
    return number;
  }

  public void updateBoard(Player player) {
    int index = getValidSquareNumber() - 1;
    this.squares[index] = player.getMarker();
    player.addToClaimedSquares(index + 1);
    printBoard();
  }

  public void close() {
    scanner.close();
  }
}
