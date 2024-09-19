import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Board {
  private Scanner scanner;
  private String[] squares = new String[9];

  private ArrayList<Integer> playerXsClaimedSquares = new ArrayList<>();
  private ArrayList<Integer> playerOsClaimedSquares = new ArrayList<>();

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
      String input = scanner.nextLine().trim();

      try {
        number = Integer.parseInt(input);
        if (number < 1 || number > 9) {
          System.out.println("Invalid input. Please enter a number between 1 and 9.");
        } else if (!this.squares[number - 1].equals("-")) {
          System.out.println("Square already claimed. Please choose another square.");
        } else {
          isValidInput = true;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number between 1 and 9.");
      }
    }
    return number;
  }

  public void takeTurns() {
    // player X lays first claim of the game
    boolean isPlayerXsTurn = true;

    while (true) {
      // if current player is X, the marker to be added to the board is "X", and vice versa
      String currentPlayer = isPlayerXsTurn ? "X" : "O";
      // if current player is X, their array of claimed squares is to be updated, and vice versa
      ArrayList<Integer> currentPlayersClaimedSquares = isPlayerXsTurn ? playerXsClaimedSquares : playerOsClaimedSquares;
      
      System.out.println("Player " + currentPlayer + ", which quare (1-9)?");

      // gets valid square number from player's input
      int squareNumber = getValidSquareNumber();
      // the corresponding value ("-") in the squares array is replaced with the current player's marker
      squares[squareNumber - 1] = currentPlayer;
      // adds the now claimed square to the current player's list of claimed square
      currentPlayersClaimedSquares.add(squareNumber);

      // print updated board
      printBoard();

      // if player X has now claimed a square, it is player O's turn next, and vice versa
      isPlayerXsTurn = !isPlayerXsTurn;
    }
  }

  public void close() {
    scanner.close();
  }
}
