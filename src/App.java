public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        Player playerX = new Player("X", "X");
        Player playerO = new Player("O", "O");

        board.updateBoard(playerX.getMarker());
        board.updateBoard(playerO.getMarker());
        board.updateBoard(playerO.getMarker());

        board.close();
    }
}
