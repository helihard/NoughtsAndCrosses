import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Game game = new Game(scanner, board);
        
        game.takeTurns();

        scanner.close();
    }
}
