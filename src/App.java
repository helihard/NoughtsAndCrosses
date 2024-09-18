public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        Player playerX = new Player("X");
        Player playerO = new Player("O");

        board.updateBoard(9, playerX.getMarker());
        board.updateBoard(9, playerO.getMarker());
        board.updateBoard(8, playerO.getMarker());
    }
}
