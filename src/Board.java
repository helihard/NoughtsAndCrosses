import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
  private Scanner scanner;
  private String[] squares = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

  private ArrayList<Integer> playerXsClaimedSquares = new ArrayList<>();
  private ArrayList<Integer> playerOsClaimedSquares = new ArrayList<>();

  private final List<List<Integer>> winningCombinations = Arrays.asList(
    // horisontal combinations (forward or reversed)
    Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9),
    // vertical combinations (forward or reversed)
    Arrays.asList(1, 4, 7), Arrays.asList(2, 5, 8), Arrays.asList(3, 6, 9),
    // diagonal combinations (upwards down or reversed)
    Arrays.asList(1, 5, 9), Arrays.asList(3, 5, 7)
  );


  // constructor
  public Board() {
    this.scanner = new Scanner(System.in);
    printBoard();
  }

  public void printBoard() {
    System.out.println("\n " + this.squares[0] + " | " + this.squares[1] + " | " + this.squares[2]);
    System.out.println("---+---+---");
    System.out.println(" " + this.squares[3] + " | " + this.squares[4] + " | " + this.squares[5]);
    System.out.println("---+---+---");
    System.out.println(" " + this.squares[6] + " | " + this.squares[7] + " | " + this.squares[8] + "\n");
  }

  // error handling 
  public int getValidSquareNumber() {
    int number = - 1;
    boolean isValidInput = false;

    while(!isValidInput) {
      String input = scanner.nextLine().trim();

      try {
        number = Integer.parseInt(input);
        if (number < 1 || number > 9) {
          System.out.println("Invalid input. Please enter a number between 1 and 9.");
        } else if (this.squares[number - 1].equals("X") || this.squares[number -1].equals("O")) {
          System.out.println("Square already claimed. Please choose another square.");
        } else {
          isValidInput = true;
        }
        // catches player input that isn't a number
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number between 1 and 9.");
      }
    }
    return number;
  }

  // check if the last claim results in a winning squares combination
  public boolean isWinner(ArrayList<Integer> currentPlayersClaimedSquares) {
    for (List<Integer> combination : winningCombinations) {
      if (currentPlayersClaimedSquares.containsAll(combination)) {
        return true;
      }
    }
    return false;
  }

  public void takeTurns() {
    // player X lays first claim of the game
    boolean isPlayerXsTurn = true;

    while (true) {
      // if current player is X, the marker to be added to the board is "X", and vice versa
      String currentPlayer = isPlayerXsTurn ? "X" : "O";
      // if current player is X, their array of claimed squares is to be updated, and vice versa
      ArrayList<Integer> currentPlayersClaimedSquares = isPlayerXsTurn ? playerXsClaimedSquares : playerOsClaimedSquares;
      
      System.out.println("Player " + currentPlayer + ", which square (1-9)?");

      // gets valid square number from player's input
      int squareNumber = getValidSquareNumber();
      // the corresponding value (1-9) in the squares array is replaced with the current player's marker ("X" or "O")
      squares[squareNumber - 1] = currentPlayer;
      // adds the now claimed square to the current player's list of claimed square
      currentPlayersClaimedSquares.add(squareNumber);

      // print updated board
      printBoard();

      if (isWinner(currentPlayersClaimedSquares)) {
        System.out.println("Player " + currentPlayer + " wins the game!");
        reset();
      }

      // if all squares are claimed and the above method has not returned true, i e there is no winner
      if (playerXsClaimedSquares.size() + playerOsClaimedSquares.size() == 9) {
        System.out.println("Game ends in a draw!");
        reset();
      }

      // if there is neither winner nor draw, the next player is in turn to claim a square
      isPlayerXsTurn = !isPlayerXsTurn;
    }
  }

  public void reset() {
    System.out.println("\nLet\'s try again!\n");
    playerXsClaimedSquares.clear();
    playerOsClaimedSquares.clear();

    for (int i = 0; i < this.squares.length; i++) {
      squares[i] = String.valueOf(i + 1);
    }

    printBoard();
    takeTurns();
  }

  public void close() {
    scanner.close();
  }
}
